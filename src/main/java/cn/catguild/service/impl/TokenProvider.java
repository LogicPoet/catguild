package cn.catguild.service.impl;

import cn.catguild.service.TokenGranter;
import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * token提供者
 *
 * @author liu.zhi
 * @date 2020/12/17 16:55
 */
@AllArgsConstructor
public class TokenProvider {

	private static Map<String,TokenGranter> granterMap = new ConcurrentHashMap<>();

	static {
		granterMap.put("password", SpringUtil.getBean(PasswordGranter.class));
	}

	/**
	 * 提供 token
	 *
	 * @param parameter 登陆参数
	 * @return jwt 令牌
	 */
	public static String provider(Map<String,String> parameter){
		String key = parameter.get("grant_type");
		return granterMap.get(key).getToken(parameter);
	}

}
