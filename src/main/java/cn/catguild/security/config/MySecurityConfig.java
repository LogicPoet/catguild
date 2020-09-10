package cn.catguild.security.config;

import cn.catguild.security.service.CustomUserDetailsService;
import cn.catguild.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationFailureHandler;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
import reactor.core.publisher.Mono;

import java.util.LinkedList;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.security.config
 * @description
 * @date Created in 2020-09-10 02:19
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Configuration
/**
 * 启用webflux登陆权限校验
 */
@EnableWebFluxSecurity
/**
 * 启用@PreAuthorize注解配置，如果不加这个注解的话，即使方法中加了@PreAuthorize也不会生效
 */
@EnableReactiveMethodSecurity
public class MySecurityConfig {

	private static final String[] AUTH_WHITELIST = new String[]{"/login", "/actuator/**"};

	/**
	 * 将登陆后的用户及权限信息存入session中
	 * @return
	 */
	@Bean
	ServerSecurityContextRepository serverSecurityContextRepository() {
		return new WebSessionServerSecurityContextRepository();
	}

	/**
	 * 密码加密工具
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 自定义获取用户信息，此处使用mysql基于RBAC模式
	 * @return
	 */
	@Bean
	public ReactiveUserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	/**
	 * 此处的代码会放在SecurityConfig类中，此处只是摘要下
	 * @param http
	 * @return
	 */
	@Bean
	SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
		ServerHttpSecurity.FormLoginSpec formLoginSpec = http.formLogin();
		//formLoginSpec.authenticationSuccessHandler(createAuthenticationSuccessHandler())
		//	.loginPage("/login")
		//	.authenticationFailureHandler(createAuthenticationFailureHandler());
		return formLoginSpec.and()
			.csrf().disable()
			.httpBasic().disable()
			.authorizeExchange()
			.pathMatchers(AUTH_WHITELIST).permitAll()
			.anyExchange().authenticated()
			.and().build();
	}

	/**
	 * 登陆成功后执行的处理器
	 * @return
	 */
	private ServerAuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new RedirectServerAuthenticationSuccessHandler("/test/list");
	}

	/**
	 * 登陆失败后执行的处理器
	 * @return
	 */
	private ServerAuthenticationFailureHandler createAuthenticationFailureHandler() {
		return new RedirectServerAuthenticationFailureHandler("/test/add");
	}
}
