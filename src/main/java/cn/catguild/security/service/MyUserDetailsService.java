package cn.catguild.security.service;

import cn.catguild.security.model.Permission;
import cn.catguild.security.model.Role;
import cn.catguild.security.model.User;
import cn.catguild.security.repository.PermissionDao;
import cn.catguild.security.repository.RoleDao;
import cn.catguild.security.repository.UserDao;
import cn.catguild.security.vo.UserPrincipal;
import cn.catguild.util.BeanCopyUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * <p>
 * 自定义UserDetails查询
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.security.service
 * @description
 * @date Created in 2020-09-10 02:28
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
public class MyUserDetailsService implements ReactiveUserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionDao permissionDao;

	/**
	 * Find the {@link UserDetails} by username.
	 *
	 * @param username the username to look up
	 * @return the {@link UserDetails}. Cannot be null
	 */
	@Override
	public Mono<UserDetails> findByUsername(String username) {

		User user = new User();
		List<Role> roles = new ArrayList<>();
		List<Permission> permissions = new ArrayList<>();

		return userDao.findByUsernameOrEmailOrPhone(username, username, username).flatMap(u -> {
			Flux<Role> roleFlux = roleDao.selectByUserId(u.getId());
			BeanCopyUtils.copy(u, user);
			roleFlux.map(r -> {
				roles.add(r);
				return r;
			}).map(Role::getId).collectList().map(r -> {
				Flux<Permission> permissionFlux = permissionDao.selectByRoleIdList(r);
				permissionFlux.map(p -> {
					permissions.add(p);
					return p;
				});
				return r;
			});
			return Mono.just(UserPrincipal.create(user, roles, permissions));
		});

	}


	///**
	// * Find the {@link UserDetails} by username.
	// *
	// * @param username the username to look up
	// * @return the {@link UserDetails}. Cannot be null
	// */
	//@Override
	//public Mono<UserDetails> findByUsername(String username) {
	//	User user = userDao.findByUsernameOrEmailOrPhone(username, username, username).blockOptional(Duration.ZERO)
	//		.orElseThrow(() -> new UsernameNotFoundException("未找到用户信息 : " + username));
	//
	//	//Mono<User> userMono = userDao.findByUsernameOrEmailOrPhone(username, username, username);
	//
	//
	//	//Optional<User> user = userMono.blockOptional(Duration.ZERO);
	//	List<Role> roles = roleDao.selectByUserId(user.getId()).collectList().block();
	//	List<Long> roleIds = roles.stream()
	//		.map(Role::getId)
	//		.collect(Collectors.toList());
	//	List<Permission> permissions = permissionDao.selectByRoleIdList(roleIds).collectList().block();
	//	UserPrincipal userPrincipal = UserPrincipal.create(user, roles, permissions);
	//	return Mono.just(userPrincipal);
	//}
}
