package cn.catguild.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhi.liu
 * @date 2021-06-30 11:53
 */
@Api(tags = "测试控制器")
@RequestMapping("/test")
@RestController
public class TestController {

	@ApiOperation("web容器启动访问测试")
	@GetMapping
	public String firstTest() {
		return "web容器启动成功！！！";
	}

}
