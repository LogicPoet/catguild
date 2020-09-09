package cn.catguild.security.service;

import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
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
	/**
	 * Find the {@link UserDetails} by username.
	 *
	 * @param username the username to look up
	 * @return the {@link UserDetails}. Cannot be null
	 */
	@Override
	public Mono<UserDetails> findByUsername(String username) {
		//User user = userDao.findByUsernameOrEmailOrPhone(username, username, username)
		//	.orElseThrow(() -> new UsernameNotFoundException("未找到用户信息 : " + username));
		//List<Role> roles = roleDao.selectByUserId(user.getId());
		//List<Long> roleIds = roles.stream()
		//	.map(Role::getId)
		//	.collect(Collectors.toList());
		//List<Permission> permissions = permissionDao.selectByRoleIdList(roleIds);
		//UserPrincipal.create(user, roles, permissions);
		return new MapReactiveUserDetailsService().findByUsername(username);
	}
}
