package cn.catguild.core.controller;

import cn.catguild.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class TestControllerTest extends ApplicationTest {

	@Autowired
	TestController controller;

    @Test
    void firstTest() {
		Mono<String> stringMono = controller.firstTest();
		String block = stringMono.block();
		assertEquals("web容器启动成功！！！", block);
	}
}
