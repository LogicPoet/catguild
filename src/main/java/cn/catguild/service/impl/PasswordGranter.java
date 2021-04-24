package cn.catguild.service.impl;

import cn.catguild.domain.entity.Staff;
import cn.catguild.exception.AuthException;
import cn.catguild.mapper.StaffMapper;
import cn.catguild.service.TokenGranter;
import cn.catguild.utils.JwtUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.zhi
 * @date 2020/12/17 16:57
 */
@Component
@AllArgsConstructor
public class PasswordGranter implements TokenGranter {

	private final StaffMapper staffMapper;

	/**
	 * 获取token
	 *
	 * @return jwt 令牌
	 */
	@Override
	public Mono<String> getToken(Map<String, String> parameter) {
		// 校验参数
		//if (!parameter.containsKey("username")){
		//	return "缺失参数: username";
		//}
		//if (!parameter.containsKey("password")){
		//	return "缺失参数: password";
		//}

		// 验证用户是否合法
		Mono<Staff> one = Mono.justOrEmpty(staffMapper.selectOne(Wrappers.<Staff>lambdaQuery()
			.eq(Staff::getJobNumber, parameter.get("username"))
			.eq(Staff::getPassword, parameter.get("password"))
			.last("limit 1")));
		return one.map(s -> {
			Map<String, String> param = new HashMap<>(2);
			param.put("name", s.getName());
			if (null == s.getId()) {
				throw new AuthException("账号或密码错误");
			}
			return JwtUtil.createJWT(param, "issuer", "audience");
		}).switchIfEmpty(
			Mono.defer(
				() -> Mono.error(new AuthException("账号或密码错误"))
			)
		);
	}

}
