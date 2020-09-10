package cn.catguild.security.service;

import cn.catguild.security.model.Permission;
import cn.catguild.security.model.Role;
import cn.catguild.security.model.User;
import cn.catguild.security.repository.PermissionDao;
import cn.catguild.security.repository.RoleDao;
import cn.catguild.security.repository.UserDao;
import cn.catguild.security.vo.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *	自定义UserDetails查询
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
@Service
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
		User user = userDao.findByUsernameOrEmailOrPhone(username, username, username).blockOptional()
			.orElseThrow(() -> new UsernameNotFoundException("未找到用户信息 : " + username));
		List<Role> roles = roleDao.selectByUserId(user.getId()).collectList().block();
		List<Long> roleIds = roles.stream()
			.map(Role::getId)
			.collect(Collectors.toList());
		List<Permission> permissions = permissionDao.selectByRoleIdList(roleIds).collectList().block();
		UserPrincipal userPrincipal = UserPrincipal.create(user, roles, permissions);
		return Mono.just(userPrincipal);
	}
}
