package cn.catguild.service;

import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.EntrustQuery;
import cn.catguild.domain.vo.EntrustSave;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author liu.zhi
 * @date 2020/12/21 17:07
 */
public interface EntrustService {

	/**
	 * 创建一个委托任务
	 *
	 * @param entrustSave 委托任务信息
	 * @return 委托任务id
	 */
	Mono<String> submit(EntrustSave entrustSave);

	/**
	 * 获取委托分页列表
	 *
	 * @param entrustQuery 查询参数
	 * @return 委托分页列表
	 */
	Flux<Entrust> page(EntrustQuery entrustQuery);

	/**
	 * 获取委托详情
	 *
	 * @param entrustQuery 查询参数
	 * @return 委托详情
	 */
	Mono<Entrust> detail(EntrustQuery entrustQuery);

	/**
	 * 变更委托任务信息
	 *
	 * @param entrustSave 委托任务信息
	 * @return 委托任务id
	 */
	Mono<String> update(EntrustSave entrustSave);

}
