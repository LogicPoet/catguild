package cn.catguild.controller;

import cn.catguild.common.CommonResult;
import cn.catguild.service.ITaskService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
public class TaskController {

	private final ITaskService taskService;

	/**
	 * 创建一个新任务
	 *
	 * @return
	 */
	@PostMapping("/task")
	public CommonResult postTask() {
		return null;
	}

	/**
	 * 列出所有任务
	 *
	 * @return
	 */
	@GetMapping("/task")
	public CommonResult getTask() {
		return null;
	}

	/**
	 * 批量更新任务信息
	 *
	 * @return
	 */
	@PutMapping("/task")
	public CommonResult putTask() {
		return null;
	}

	/**
	 * 删除所有任务
	 *
	 * @return
	 */
	@DeleteMapping("/task")
	public CommonResult deleteTask() {
		return null;
	}


	/**
	 * 列出任务
	 *
	 * @return
	 */
	@GetMapping("/task/{id}")
	public CommonResult getTask(@PathVariable("id") Integer id) {
		return null;
	}

	/**
	 * 更新任务信息
	 *
	 * @return
	 */
	@PutMapping("/task/{id}")
	public CommonResult putTask(@PathVariable("id") Integer id) {
		return null;
	}

	/**
	 * 删除任务
	 *
	 * @return
	 */
	@DeleteMapping("/task/{ids}")
	public CommonResult deleteTask(@PathVariable("ids") String ids) {
		return null;
	}

}
