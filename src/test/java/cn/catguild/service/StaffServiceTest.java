package cn.catguild.service;

import cn.catguild.ApplicationTest;
import cn.catguild.domain.entity.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试职员服务
 */
class StaffServiceTest extends ApplicationTest {

	@Autowired
	StaffService staffService;

	/**
	 * 添加职员
	 */
	@Test
	void submit() {
		Staff staff = new Staff();
		staff.setJobNumber("1");
		staff.setPassword("2");
		staff.setName("3");
		staff.setSex((short) 4);
		staff.setAge((short) 5);
		staffService.submit(staff).subscribe();
	}

	@Test
	void remove() {
	}

	@Test
	void page() {
	}

	@Test
	void getOne() {
	}
}
