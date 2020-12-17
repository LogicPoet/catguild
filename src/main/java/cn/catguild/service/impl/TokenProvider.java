package cn.catguild.service.impl;

import cn.catguild.dao.StaffDao;
import cn.catguild.service.TokenGranter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * token提供者
 *
 * @author liu.zhi
 * @date 2020/12/17 16:55
 */
@Component
public class TokenProvider {



	private static final Map<String,TokenGranter> granterMap = new ConcurrentHashMap<>();

	static {
		//TokenGranter passwordGranter = new PasswordGranter(staffDao);
		//granterMap.put("password",passwordGranter);
	}

	/**
	 * 提供 token
	 *
	 * @param parameter 登陆参数
	 * @return jwt 令牌
	 */
	public static String provider(Map<String,String> parameter){
		String key = parameter.get("grant_type");
		TokenGranter tokenGranter = granterMap.get(key);
		return tokenGranter.getToken(parameter);
	}

}
