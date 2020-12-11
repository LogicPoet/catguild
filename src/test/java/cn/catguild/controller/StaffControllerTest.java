package cn.catguild.controller;

import cn.catguild.ApplicationTest;
import cn.catguild.domain.entity.Staff;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
public class StaffControllerTest extends ApplicationTest {

	@Autowired
	StaffController controller;

	@Test
	public void submit() {
		Staff staff = new Staff();
		staff.setName("李月");
		staff.setAge((short) 28);
		staff.setSex((short) 1);
		staff.setCrateTime(Instant.now().toEpochMilli());
		try {
			Mono<Staff> submit = controller.submit(staff);
			//log.debug("成功保存：{}", submit.block());
		} catch (Exception e) {
			//log.error("保存失败：{}", e.getMessage());
		}
	}

	@Test
	public void page() {
	}

	@Test
	public void remove() {
	}
}
