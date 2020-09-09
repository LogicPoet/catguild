package cn.catguild.security.config;

import cn.catguild.security.common.Status;
import cn.catguild.security.service.CustomUserDetailsService;
import cn.catguild.security.util.JwtUtil;
import cn.catguild.security.util.ResponseUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.security.config
 * @description
 * @date Created in 2020-09-09 23:11
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Component
@Slf4j
public class JwtAuthenticationFilter implements WebFilter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomConfig customConfig;

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

		if (checkIgnores(request)) {
			return chain.filter(exchange);
		}

		String jwt = jwtUtil.getJwtFromRequest(request);

		if (StrUtil.isNotBlank(jwt)) {
			try {
				String username = jwtUtil.getUsernameFromJWT(jwt);

				UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				//authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext()
					.setAuthentication(authentication);
				return chain.filter(exchange);
			} catch (SecurityException e) {
//				ResponseUtil.renderJson(exchange.getResponse(), e);
			}
		} else {
//			ResponseUtil.renderJson(exchange.getResponse(), Status.UNAUTHORIZED, null);
		}
		return chain.filter(exchange);
	}

	/**
	 * 请求是否不需要进行权限拦截
	 *
	 * @param request 当前请求
	 * @return true - 忽略，false - 不忽略
	 */
	private boolean checkIgnores(ServerHttpRequest request) {
		HttpMethod httpMethod = request.getMethod();

		if (ObjectUtil.isNull(httpMethod)) {
			httpMethod = HttpMethod.GET;
		}

		Set<String> ignores = Sets.newHashSet();

		switch (httpMethod) {
			case GET:
				ignores.addAll(customConfig.getIgnores()
					.getGet());
				break;
			case PUT:
				ignores.addAll(customConfig.getIgnores()
					.getPut());
				break;
			case HEAD:
				ignores.addAll(customConfig.getIgnores()
					.getHead());
				break;
			case POST:
				ignores.addAll(customConfig.getIgnores()
					.getPost());
				break;
			case PATCH:
				ignores.addAll(customConfig.getIgnores()
					.getPatch());
				break;
			case TRACE:
				ignores.addAll(customConfig.getIgnores()
					.getTrace());
				break;
			case DELETE:
				ignores.addAll(customConfig.getIgnores()
					.getDelete());
				break;
			case OPTIONS:
				ignores.addAll(customConfig.getIgnores()
					.getOptions());
				break;
			default:
				break;
		}

		ignores.addAll(customConfig.getIgnores()
			.getPattern());

		if (CollUtil.isNotEmpty(ignores)) {
			for (String ignore : ignores) {
//				AntPathRequestMatcher matcher = new AntPathRequestMatcher(ignore, method);
//				if (matcher.matches(request)) {
//					return true;
//				}
			}
		}

		return false;
	}


}
