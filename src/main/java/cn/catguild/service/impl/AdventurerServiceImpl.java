package cn.catguild.service.impl;

import cn.catguild.domain.entity.Adventurer;
import cn.catguild.domain.vo.AdventurerQuery;
import cn.catguild.domain.vo.AdventurerSave;
import cn.catguild.mapper.AdventurerMapper;
import cn.catguild.service.AdventurerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author liu.zhi
 * @date 2020/12/24 13:53
 */
@Service
@AllArgsConstructor
public class AdventurerServiceImpl extends BaseServiceImpl<AdventurerMapper, Adventurer> implements AdventurerService {


	@Override
	public Mono<String> submit(AdventurerSave adventurerSave) {
		return null;
	}

	@Override
	public Flux<Adventurer> page(AdventurerQuery adventurerQuery) {
		return null;
	}

	@Override
	public Mono<Adventurer> detail(AdventurerQuery adventurerQuery) {
		return null;
	}

	@Override
	public Mono<String> update(AdventurerSave adventurerSave) {
		return null;
	}
}
