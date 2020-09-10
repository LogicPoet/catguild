package cn.catguild.security.repository;

import cn.catguild.ApplicationTest;
import cn.catguild.security.model.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 * UserDao 测试
 * </p>
 *
 * @package: com.xkcoding.rbac.security.repository
 * @description: UserDao 测试
 * @author: yangkai.shen
 * @date: Created in 2018-12-12 01:10
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class UserDaoTest extends ApplicationTest {
    @Autowired
    private UserDao userDao;

	@Test
	public void selectAllCountries() {
		Flux<User> allById = userDao.findAllCountries();
		log.info("【userList】= {}", allById.collectList().block());
	}

	@Test
	public void findByUsernameOrEmailOrPhone() {
		Mono<User> allById = userDao.findByUsernameOrEmailOrPhone("admin","admin","admin");
		log.info("【userList】= {}", allById.block());
	}

    @Test
    public void findByUsernameIn() {
        List<String> usernameList = Lists.newArrayList("admin", "user");
		Flux<User> byUsernameIn = userDao.findByUsernameIn(usernameList);
		List<User> userList = byUsernameIn.collectList().block();
        log.info("【userList】= {}", userList);
        log.info("【userList】= {}", userList.size());
        //log.info("【userList】= {}", byUsernameIn);
    }


	@Test
	public void findAllById() {
		List<Long> usernameList = Lists.newArrayList(1303892154682314752L, 2L);
		Flux<User> allById = userDao.findAllById(Flux.fromIterable(usernameList));
		log.info("【userList】= {}", allById.collectList().block());
	}

}
