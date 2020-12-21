package cn.catguild.controller;

import cn.catguild.ApplicationTest;
import cn.catguild.common.api.R;
import cn.catguild.dao.StaffDao;
import cn.catguild.domain.entity.Staff;
import cn.catguild.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AuthControllerTest extends ApplicationTest {

	@Autowired
	AuthController authController;

	@Autowired
	StaffDao staffDao;

	@Test
	public void login() {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("grant_type", "password");
		parameter.put("username", "0000012");
		parameter.put("password", "asdfg");
		Mono<R<String>> login = authController.login(parameter);
		log.debug("结果：{}",login.block().getData());
	}

	@Test
	public void test() {

		Mono.just("123").subscribe(s->{
			if (s.equals("123")){
				throw new AuthException("账号或密码错误");
			}
		});

	}

	@Test
	public void test2() {
		Map<String, String> parameter = new HashMap<>();
		Staff staff = new Staff();
		staff.setJobNumber(parameter.get("username"));
		staff.setPassword(parameter.get("password"));
		Mono<Staff> one = staffDao.findOne(Example.of(staff));
		Map<String, String> param = new HashMap<>(2);
		one.subscribe(s->{
			throw new AuthException("账号或密码错误");
		});

	}

}
