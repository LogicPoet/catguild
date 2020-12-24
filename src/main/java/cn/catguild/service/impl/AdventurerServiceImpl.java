package cn.catguild.service.impl;

import cn.catguild.dao.AdventurerDao;
import cn.catguild.domain.entity.Adventurer;
import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.AdventurerQuery;
import cn.catguild.domain.vo.AdventurerSave;
import cn.catguild.domain.vo.EntrustSave;
import cn.catguild.service.AdventurerService;
import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author liu.zhi
 * @date 2020/12/24 13:53
 */
@Service
@AllArgsConstructor
public class AdventurerServiceImpl implements AdventurerService {

	private AdventurerDao adventurerDao;

	/**
	 * 创建一个冒险家账户
	 *
	 * @param adventurerSave 冒险家账户信息
	 * @return 冒险家账户id
	 */
	@Override
	public Mono<String> submit(AdventurerSave adventurerSave) {
		Adventurer adventurer = new Adventurer();
		BeanUtil.copyProperties(adventurerSave,adventurer);
		return adventurerDao.save(adventurer).map(Adventurer::getId);
	}

	/**
	 * 获取冒险家账户信息分页列表
	 *
	 * @param adventurerQuery 查询参数
	 * @return 冒险家账户信息分页列表
	 */
	@Override
	public Flux<Adventurer> page(AdventurerQuery adventurerQuery) {
		Adventurer adventurer = new Adventurer();
		BeanUtil.copyProperties(adventurerQuery,adventurer);
		return adventurerDao.findAll(Example.of(adventurer));
	}

	/**
	 * 获取冒险家账户信息详情
	 *
	 * @param adventurerQuery 查询参数
	 * @return 冒险家账户信息
	 */
	@Override
	public Mono<Adventurer> detail(AdventurerQuery adventurerQuery) {
		Adventurer adventurer = new Adventurer();
		BeanUtil.copyProperties(adventurerQuery,adventurer);
		return adventurerDao.findOne(Example.of(adventurer));
	}

	/**
	 * 变更冒险家账户信息
	 *
	 * @param adventurerSave 冒险家账户信息
	 * @return 冒险家账户id
	 */
	@Override
	public Mono<String> update(AdventurerSave adventurerSave) {
		Adventurer adventurer = new Adventurer();
		BeanUtil.copyProperties(adventurerSave,adventurer);
		return adventurerDao.save(adventurer).map(Adventurer::getId);
	}
}
