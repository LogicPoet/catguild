package cn.catguild.dao;

import cn.catguild.domain.entity.Staff;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * 职员持久层
 *
 * @author liu.zhi
 * @date 2020/12/11 17:49
 */
public interface StaffDao extends ReactiveMongoRepository<Staff, Integer> {

}
