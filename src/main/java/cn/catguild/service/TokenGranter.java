package cn.catguild.service;

import reactor.core.publisher.Mono;

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
	 * @param parameter 参数
	 * @return jwt 令牌
	 */
	Mono<String> getToken(Map<String,String> parameter);

}
