package cn.catguild.filter;

import cn.catguild.common.api.ResponseProvider;
import cn.catguild.provider.AuthProvider;
import cn.catguild.utils.JwtUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author liu.zhi
 * @date 2020/12/18 17:50
 */
@Slf4j
@Component
@AllArgsConstructor
public class AuthFilter implements WebFilter{

	private final ObjectMapper objectMapper;

	/**
	 * Process the Web request and (optionally) delegate to the next
	 * {@code WebFilter} through the given {@link WebFilterChain}.
	 *
	 * @param exchange the current server exchange
	 * @param chain    provides a way to delegate to the next filter
	 * @return {@code Mono<Void>} to indicate when request processing is complete
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		String path = request.getURI().getPath();
		// 是否跳过鉴权
		if (isSkip(path)) {
			return chain.filter(exchange);
		}

		String headerToken = request.getHeaders().getFirst(AuthProvider.AUTH_KEY);
		String paramToken = request.getQueryParams().getFirst(AuthProvider.AUTH_KEY);

		ServerHttpResponse resp = exchange.getResponse();
		if (StrUtil.isAllBlank(headerToken, paramToken)) {
			return unAuth(resp, "缺失令牌,鉴权失败");
		}

		String auth = StrUtil.isBlank(headerToken) ? paramToken : headerToken;
		String token = JwtUtil.getToken(auth);
		Claims claims = JwtUtil.parseJWT(token);
		if (claims == null) {

			return unAuth(resp, "请求未授权");
		}
		return chain.filter(exchange);
	}

	/**
	 * 判断是否跳过鉴权
	 *
	 * @param path 访问url
	 * @return
	 */
	private boolean isSkip(String path) {
		return AuthProvider.getDefaultSkipUrl().stream()
			.map(url -> url.replace(AuthProvider.TARGET, AuthProvider.REPLACEMENT))
			.anyMatch(path::contains);
	}

	/**
	 * 回写 resp
	 *
	 * @param resp
	 * @param msg
	 * @return
	 */
	private Mono<Void> unAuth(ServerHttpResponse resp, String msg) {
		resp.setStatusCode(HttpStatus.UNAUTHORIZED);
		resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
		String result = "";
		try {
			result = objectMapper.writeValueAsString(ResponseProvider.unAuth(msg));
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		DataBuffer buffer = resp.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
		return resp.writeWith(Flux.just(buffer));
	}

}
