package cn.catguild.dao;

import cn.catguild.ApplicationTest;
import cn.catguild.domain.entity.Staff;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Mono;

@Slf4j
public class StaffDaoTest extends ApplicationTest {

	@Autowired
	StaffDao staffDao;

	@Test
	public void findOne(){
		Staff staff = new Staff();
		staff.setJobNumber("000001");
		staff.setPassword("asdfg");
		Mono<Staff> one = staffDao.findOne(Example.of(staff));
		log.debug("查询结果：{}",one.subscribe());
		one.subscribe(s->{
			log.debug("订阅结果：{}",s.getPassword());
		});
		one.block();
	}

}
