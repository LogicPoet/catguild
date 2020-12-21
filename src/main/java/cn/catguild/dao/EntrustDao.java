package cn.catguild.dao;

import cn.catguild.domain.entity.Entrust;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * 委托任务持久层
 *
 * @author liu.zhi
 * @date 2020/12/21 18:20
 */
public interface EntrustDao extends ReactiveMongoRepository<Entrust, String> {

}
