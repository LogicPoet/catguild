package cn.catguild.core.controller;

import cn.catguild.core.service.IUserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 控制器
 *
 * @author
 * @since 2021-07-03
 */
@RestController
@AllArgsConstructor
@RequestMapping("/")
@Api(value = "用户表", tags = "用户表接口")
public class UserController {

	private final IUserService userService;

	///**
	// * 详情
	// */
	//@GetMapping("/detail")
	//@ApiOperationSupport(order = 1)
	//@ApiOperation(value = "详情", notes = "传入user")
	//public R<User> detail(User user) {
	//	User detail = userService.getOne(Condition.getQueryWrapper(user));
	//	return R.data(detail);
	//}
	//
	///**
	// * 分页 用户表
	// */
	//@GetMapping("/list")
	//@ApiOperationSupport(order = 2)
	//@ApiOperation(value = "分页", notes = "传入user")
	//public R<IPage<User>> list(User user, Query query) {
	//	IPage<User> pages = userService.page(Condition.getPage(query), Condition.getQueryWrapper(user));
	//	return R.data(pages);
	//}
	//
	///**
	// * 自定义分页 用户表
	// */
	//@GetMapping("/page")
	//@ApiOperationSupport(order = 3)
	//@ApiOperation(value = "分页", notes = "传入user")
	//public R<IPage<UserVO>> page(UserVO user, Query query) {
	//	IPage<UserVO> pages = userService.selectUserPage(Condition.getPage(query), user);
	//	return R.data(pages);
	//}
	//
	///**
	// * 新增 用户表
	// */
	//@PostMapping("/save")
	//@ApiOperationSupport(order = 4)
	//@ApiOperation(value = "新增", notes = "传入user")
	//public R save(@Valid @RequestBody User user) {
	//	return R.status(userService.save(user));
	//}
	//
	///**
	// * 修改 用户表
	// */
	//@PostMapping("/update")
	//@ApiOperationSupport(order = 5)
	//@ApiOperation(value = "修改", notes = "传入user")
	//public R update(@Valid @RequestBody User user) {
	//	return R.status(userService.updateById(user));
	//}
	//
	///**
	// * 新增或修改 用户表
	// */
	//@PostMapping("/submit")
	//@ApiOperationSupport(order = 6)
	//@ApiOperation(value = "新增或修改", notes = "传入user")
	//public R submit(@Valid @RequestBody User user) {
	//	return R.status(userService.saveOrUpdate(user));
	//}
	//
	//
	///**
	// * 删除 用户表
	// */
	//@PostMapping("/remove")
	//@ApiOperationSupport(order = 7)
	//@ApiOperation(value = "逻辑删除", notes = "传入ids")
	//public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
	//	return R.status(userService.deleteLogic(Func.toIntList(ids)));
	//}


}
