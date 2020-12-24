package cn.catguild.dao;

import cn.catguild.domain.entity.Adventurer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author liu.zhi
 * @date 2020/12/24 13:54
 */
public interface AdventurerDao extends ReactiveMongoRepository<Adventurer, String> {
}
