package cn.catguild.service.impl;

import cn.catguild.dao.StaffDao;
import cn.catguild.domain.entity.Staff;
import cn.catguild.service.TokenGranter;
import cn.catguild.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author liu.zhi
 * @date 2020/12/17 16:57
 */
@Service
@AllArgsConstructor
public class PasswordGranter implements TokenGranter {

	StaffDao staffDao;

	/**
	 * 获取token
	 *
	 * @return jwt 令牌
	 */
	@Override
	public String getToken(Map<String,String> parameter) {
		// 校验参数
		if (!parameter.containsKey("username")){
			return "缺失参数: username";
		}
		if (!parameter.containsKey("password")){
			return "缺失参数: password";
		}

		// 验证用户是否合法
		Staff staff = new Staff();
		staff.setJobNumber(parameter.get("username"));
		staff.setPassword(parameter.get("password"));
		Mono<Staff> one = staffDao.findOne(Example.of(staff));
		Staff block = one.block();
		String jwt = JwtUtil.createJwt(block.getJobNumber());
		return jwt;
	}

}
