package cn.catguild.controller;

import cn.catguild.service.IUserTaskService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务表表 控制器
 *
 * @author
 * @since 2021-05-28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/")
@Api(value = "任务表表", tags = "任务表表接口")
public class UserTaskController {

	private final IUserTaskService userTaskService;

}
