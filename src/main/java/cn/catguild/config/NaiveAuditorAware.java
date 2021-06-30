package cn.catguild.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * jpa审计，登陆用户
 *
 * @author LZ
 * @date 2020/9/9 15:07
 **/
@Component
public class NaiveAuditorAware implements AuditorAware<String> {

	private String auditor = "admin";

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(auditor);
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
}

//public class AuditorAwareImpl implements AuditorAware<String> {
//
//   @Override
//   public Optional<String> getCurrentAuditor() {
//      return Optional.of("Ramesh");
//      // Use below commented code when will use Spring Security.
//   }
//}
//
//// ------------------ Use below code for spring security --------------------------
//
///*class SpringSecurityAuditorAware implements AuditorAware<User> {
//
// public User getCurrentAuditor() {
//
//  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//  if (authentication == null || !authentication.isAuthenticated()) {
//   return null;
//  }
//
//  return ((MyUserDetails) authentication.getPrincipal()).getUser();
// }
//}*/
