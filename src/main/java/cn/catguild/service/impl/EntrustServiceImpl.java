package cn.catguild.service.impl;

import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.EntrustQuery;
import cn.catguild.domain.vo.EntrustSave;
import cn.catguild.mapper.EntrustMapper;
import cn.catguild.service.EntrustService;
import lombok.AllArgsConstructor;
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
public class EntrustServiceImpl extends BaseServiceImpl<EntrustMapper, Entrust> implements EntrustService {


	@Override
	public Mono<String> submit(EntrustSave entrustSave) {
		return null;
	}

	@Override
	public Flux<Entrust> page(EntrustQuery entrustQuery) {
		return null;
	}

	@Override
	public Mono<Entrust> detail(EntrustQuery entrustQuery) {
		return null;
	}

	@Override
	public Mono<String> update(EntrustSave entrustSave) {
		return null;
	}
}
