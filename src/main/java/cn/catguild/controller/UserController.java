package cn.catguild.controller;

import cn.catguild.common.CommonResult;
import cn.catguild.domain.entity.User;
import cn.catguild.domain.vo.UserSave;
import cn.catguild.domain.vo.UserVO;
import cn.catguild.service.IUserService;
import cn.catguild.utils.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 用户表 控制器
 *
 * @author
 * @since 2021-05-28
 */
@Validated
@Transactional(rollbackFor = Exception.class)
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value = "用户表", tags = "用户表接口")
public class UserController {

	private final IUserService userService;

	/**
	 * 创建一个新用户
	 *
	 * @return
	 */
	@PostMapping("")
	public CommonResult<UserSave> postUser(@RequestBody UserSave userSave) {
		boolean result = userService.register(userSave);
		return result ? CommonResult.data(userSave) : CommonResult.failed();
	}

	/**
	 * 列出所有用户
	 *
	 * @return
	 */
	@GetMapping("")
	public CommonResult<List<UserVO>> getUser(String keyword, IPage<User> page) {
		List<UserVO> result = userService.getPage(keyword, page);
		return CommonResult.data(result);
	}

	/**
	 * 批量更新用户信息
	 *
	 * @return
	 */
	@PutMapping("")
	public CommonResult putUser() {
		return null;
	}

	/**
	 * 删除所有用户
	 *
	 * @return
	 */
	@DeleteMapping("")
	public CommonResult deleteUser() {
		boolean remove = userService.logout(null);
		return CommonResult.status(remove);
	}

	/**
	 * 列出用户信息
	 *
	 * @return
	 */
	@GetMapping("/{id}")
	public CommonResult<User> getUser(@PathVariable("id") Integer id) {
		User byId = userService.getById(id);
		return CommonResult.data(byId);
	}

	/**
	 * 更新用户信息
	 *
	 * @return
	 */
	@PutMapping("/{id}")
	public CommonResult<UserVO> putUser(@RequestBody UserVO userVO, @PathVariable("id") Integer id) {
		userVO.setId(id);
		User user = new User();
		BeanUtil.copy(user, userVO);
		boolean save = userService.save(user);
		return save ? CommonResult.data(userVO) : CommonResult.status(save);
	}

	/**
	 * 删除信息
	 *
	 * @return
	 */
	@DeleteMapping("/{id}")
	public CommonResult<Boolean> deleteUser(@PathVariable("id") Integer id) {
		boolean remove = userService.logout(Collections.singletonList(id));
		return CommonResult.status(remove);
	}

}
