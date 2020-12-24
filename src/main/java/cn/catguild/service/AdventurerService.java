package cn.catguild.service;

import cn.catguild.domain.entity.Adventurer;
import cn.catguild.domain.vo.AdventurerQuery;
import cn.catguild.domain.vo.AdventurerSave;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author liu.zhi
 * @date 2020/12/24 13:53
 */
public interface AdventurerService {

	/**
	 * 创建一个冒险家账户
	 *
	 * @param adventurerSave 冒险家账户信息
	 * @return 冒险家账户id
	 */
	Mono<String> submit(AdventurerSave adventurerSave);

	/**
	 * 获取冒险家账户信息分页列表
	 *
	 * @param adventurerQuery 查询参数
	 * @return 冒险家账户信息分页列表
	 */
	Flux<Adventurer> page(AdventurerQuery adventurerQuery);

	/**
	 * 获取冒险家账户信息详情
	 *
	 * @param adventurerQuery 查询参数
	 * @return 冒险家账户信息
	 */
	Mono<Adventurer> detail(AdventurerQuery adventurerQuery);

	/**
	 * 变更冒险家账户信息
	 *
	 * @param adventurerSave 冒险家账户信息
	 * @return 冒险家账户id
	 */
	Mono<String> update(AdventurerSave adventurerSave);

}
