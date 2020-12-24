package cn.catguild.service.impl;

import cn.catguild.dao.EntrustDao;
import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.EntrustQuery;
import cn.catguild.domain.vo.EntrustSave;
import cn.catguild.service.EntrustService;
import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 委托任务 信息服务
 *
 * @author liu.zhi
 * @date 2020/12/21 17:07
 */
@Service
@AllArgsConstructor
public class EntrustServiceImpl implements EntrustService {

	private EntrustDao entrustDao;

	/**
	 * 创建一个委托任务
	 *
	 * @param entrustSave 委托任务信息
	 * @return 委托任务id
	 */
	@Override
	public Mono<String> submit(EntrustSave entrustSave) {
		Entrust entrust = new Entrust();
		BeanUtil.copyProperties(entrustSave,entrust);
		return entrustDao.save(entrust).map(Entrust::getId);
	}

	/**
	 * 获取委托分页列表
	 *
	 * @param entrustQuery 查询参数
	 * @return 委托分页列表
	 */
	@Override
	public Flux<Entrust> page(EntrustQuery entrustQuery) {
		Entrust entrust = new Entrust();
		BeanUtil.copyProperties(entrustQuery,entrust);
		return entrustDao.findAll(Example.of(entrust));
	}

	/**
	 * 获取委托详情
	 *
	 * @param entrustQuery 查询参数
	 * @return 委托详情
	 */
	@Override
	public Mono<Entrust> detail(EntrustQuery entrustQuery) {
		Entrust entrust = new Entrust();
		BeanUtil.copyProperties(entrustQuery,entrust);
		return entrustDao.findOne(Example.of(entrust));
	}

	/**
	 * 变更委托任务信息
	 *
	 * @param entrustSave 委托任务信息
	 * @return 委托任务id
	 */
	@Override
	public Mono<String> update(EntrustSave entrustSave) {
		Entrust entrust = new Entrust();
		BeanUtil.copyProperties(entrustSave,entrust);
		return entrustDao.save(entrust).map(Entrust::getId);
	}

}
