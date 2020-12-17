package cn.catguild.service;

import java.util.Map;

/**
 * 登陆统一授权器
 *
 * @author liu.zhi
 * @date 2020/12/17 16:44
 */
public interface TokenGranter {

	/**
	 * 获取token
	 *
	 * @return jwt 令牌
	 */
	String getToken(Map<String,String> parameter);

}
