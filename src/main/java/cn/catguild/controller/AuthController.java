package cn.catguild.controller;

import cn.catguild.common.api.R;
import cn.catguild.provider.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 登陆授权
 *
 * @author liu.zhi
 * @date 2020/12/17 16:39
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	ApplicationContext applicationContext;

	/**
	 * 登陆授权
	 * (多种授权方式)
	 *
	 * grant_type : 授权方式 password-[登陆凭证+密码]
	 * username: 用户名
	 * password: 密码
	 * @return jwt令牌
	 */
	@PostMapping("/login")
	public Mono<R<String>> login(@RequestBody Map<String,String> parameter){
		// 授权方式必填
		if (!parameter.containsKey("grant_type")){
			return Mono.just("缺失参数: grant_type").map(R::data);
		}
		return Mono.just(TokenProvider.provider(parameter)).map(R::data);
	}

}
