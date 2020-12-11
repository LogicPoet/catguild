package cn.catguild.controller;

import cn.catguild.domain.entity.Staff;
import cn.catguild.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * 职员接口
 * 1、有关职员的信息的管理，增删改查
 * 2、只有职员能登陆后台
 *
 * @author liu.zhi
 * @date 2020/12/11 16:08
 */
@RestController
@RequestMapping("/staff")
@AllArgsConstructor
public class StaffController {

	private  StaffService staffService;

	// 保存职员
	@PostMapping("/submit")
	public Mono<Staff> submit(@RequestBody Staff staff){
		return staffService.submit(staff);
	}

	// 分页查询职员列表
	@GetMapping("/page")
	public Flux<Staff> page(){
		return staffService.page();
	}

	// 批量删除职员
	@DeleteMapping("/{ids}")
	public Mono<Void> remove(@PathVariable String ids){
		return staffService.remove(1);
	}

}
