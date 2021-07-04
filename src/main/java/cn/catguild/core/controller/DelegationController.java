package cn.catguild.core.controller;

import cn.catguild.core.service.IDelegationService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 委托表 控制器
 *
 * @author
 * @since 2021-07-03
 */
@RestController
@AllArgsConstructor
@RequestMapping("/")
@Api(value = "委托表", tags = "委托表接口")
public class DelegationController {

	private final IDelegationService delegationService;

	///**
	// * 详情
	// */
	//@GetMapping("/detail")
	//@ApiOperationSupport(order = 1)
	//@ApiOperation(value = "详情", notes = "传入delegation")
	//public R<Delegation> detail(Delegation delegation) {
	//	Delegation detail = delegationService.getOne(Condition.getQueryWrapper(delegation));
	//	return R.data(detail);
	//}
	//
	///**
	// * 分页 委托表
	// */
	//@GetMapping("/list")
	//@ApiOperationSupport(order = 2)
	//@ApiOperation(value = "分页", notes = "传入delegation")
	//public R<IPage<Delegation>> list(Delegation delegation, Query query) {
	//	IPage<Delegation> pages = delegationService.page(Condition.getPage(query), Condition.getQueryWrapper(delegation));
	//	return R.data(pages);
	//}
	//
	///**
	// * 自定义分页 委托表
	// */
	//@GetMapping("/page")
	//@ApiOperationSupport(order = 3)
	//@ApiOperation(value = "分页", notes = "传入delegation")
	//public R<IPage<DelegationVO>> page(DelegationVO delegation, Query query) {
	//	IPage<DelegationVO> pages = delegationService.selectDelegationPage(Condition.getPage(query), delegation);
	//	return R.data(pages);
	//}
	//
	///**
	// * 新增 委托表
	// */
	//@PostMapping("/save")
	//@ApiOperationSupport(order = 4)
	//@ApiOperation(value = "新增", notes = "传入delegation")
	//public R save(@Valid @RequestBody Delegation delegation) {
	//	return R.status(delegationService.save(delegation));
	//}
	//
	///**
	// * 修改 委托表
	// */
	//@PostMapping("/update")
	//@ApiOperationSupport(order = 5)
	//@ApiOperation(value = "修改", notes = "传入delegation")
	//public R update(@Valid @RequestBody Delegation delegation) {
	//	return R.status(delegationService.updateById(delegation));
	//}
	//
	///**
	// * 新增或修改 委托表
	// */
	//@PostMapping("/submit")
	//@ApiOperationSupport(order = 6)
	//@ApiOperation(value = "新增或修改", notes = "传入delegation")
	//public R submit(@Valid @RequestBody Delegation delegation) {
	//	return R.status(delegationService.saveOrUpdate(delegation));
	//}
	//
	//
	///**
	// * 删除 委托表
	// */
	//@PostMapping("/remove")
	//@ApiOperationSupport(order = 7)
	//@ApiOperation(value = "逻辑删除", notes = "传入ids")
	//public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
	//	return R.status(delegationService.deleteLogic(Func.toIntList(ids)));
	//}


}
