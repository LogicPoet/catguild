package cn.catguild.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhi.liu
 * @date 2021-06-30 11:53
 */
@RequestMapping("/test")
@RestController
public class TestController {

	@GetMapping
	public String firstTest() {
		return "web容器启动成功！！！";
	}

}
