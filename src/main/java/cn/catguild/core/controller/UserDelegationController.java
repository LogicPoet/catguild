package cn.catguild.core.controller;

import cn.catguild.core.service.IUserDelegationService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接取委托表 控制器
 *
 * @author
 * @since 2021-07-03
 */
@RestController
@AllArgsConstructor
@RequestMapping("/")
@Api(value = "用户接取委托表", tags = "用户接取委托表接口")
public class UserDelegationController {

	private final IUserDelegationService userDelegationService;
	//
	///**
	// * 详情
	// */
	//@GetMapping("/detail")
	//@ApiOperationSupport(order = 1)
	//@ApiOperation(value = "详情", notes = "传入userDelegation")
	//public R<UserDelegation> detail(UserDelegation userDelegation) {
	//	UserDelegation detail = userDelegationService.getOne(Condition.getQueryWrapper(userDelegation));
	//	return R.data(detail);
	//}
	//
	///**
	// * 分页 用户接取委托表
	// */
	//@GetMapping("/list")
	//@ApiOperationSupport(order = 2)
	//@ApiOperation(value = "分页", notes = "传入userDelegation")
	//public R<IPage<UserDelegation>> list(UserDelegation userDelegation, Query query) {
	//	IPage<UserDelegation> pages = userDelegationService.page(Condition.getPage(query), Condition.getQueryWrapper(userDelegation));
	//	return R.data(pages);
	//}
	//
	///**
	// * 自定义分页 用户接取委托表
	// */
	//@GetMapping("/page")
	//@ApiOperationSupport(order = 3)
	//@ApiOperation(value = "分页", notes = "传入userDelegation")
	//public R<IPage<UserDelegationVO>> page(UserDelegationVO userDelegation, Query query) {
	//	IPage<UserDelegationVO> pages = userDelegationService.selectUserDelegationPage(Condition.getPage(query), userDelegation);
	//	return R.data(pages);
	//}
	//
	///**
	// * 新增 用户接取委托表
	// */
	//@PostMapping("/save")
	//@ApiOperationSupport(order = 4)
	//@ApiOperation(value = "新增", notes = "传入userDelegation")
	//public R save(@Valid @RequestBody UserDelegation userDelegation) {
	//	return R.status(userDelegationService.save(userDelegation));
	//}
	//
	///**
	// * 修改 用户接取委托表
	// */
	//@PostMapping("/update")
	//@ApiOperationSupport(order = 5)
	//@ApiOperation(value = "修改", notes = "传入userDelegation")
	//public R update(@Valid @RequestBody UserDelegation userDelegation) {
	//	return R.status(userDelegationService.updateById(userDelegation));
	//}
	//
	///**
	// * 新增或修改 用户接取委托表
	// */
	//@PostMapping("/submit")
	//@ApiOperationSupport(order = 6)
	//@ApiOperation(value = "新增或修改", notes = "传入userDelegation")
	//public R submit(@Valid @RequestBody UserDelegation userDelegation) {
	//	return R.status(userDelegationService.saveOrUpdate(userDelegation));
	//}
	//
	//
	///**
	// * 删除 用户接取委托表
	// */
	//@PostMapping("/remove")
	//@ApiOperationSupport(order = 7)
	//@ApiOperation(value = "逻辑删除", notes = "传入ids")
	//public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
	//	return R.status(userDelegationService.deleteLogic(Func.toIntList(ids)));
	//}


}
