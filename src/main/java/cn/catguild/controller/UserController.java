package cn.catguild.controller;

import cn.catguild.common.api.R;
import cn.catguild.domain.base.CatUser;
import cn.catguild.domain.entity.Staff;
import cn.catguild.service.StaffService;
import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 用户中心
 *
 * @author liu.zhi
 * @date 2020/12/24 16:17
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	private StaffService staffService;

	@GetMapping("/info")
	public Mono<R<CatUser>> info(CatUser catUser) {
		return staffService.getOne(catUser.getId()).map(staff -> {
			CatUser catUserResult = new CatUser();
			BeanUtil.copyProperties(staff,catUserResult);
			return R.data(catUserResult);
		});
	}

}
