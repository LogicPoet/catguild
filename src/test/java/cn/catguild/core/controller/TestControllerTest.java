package cn.catguild.core.controller;

import cn.catguild.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestControllerTest extends ApplicationTest {

	@Autowired
	TestController controller;

    @Test
    void firstTest() {
		String stringMono = controller.firstTest();
		assertEquals("web容器启动成功！！！", stringMono);
	}
}
