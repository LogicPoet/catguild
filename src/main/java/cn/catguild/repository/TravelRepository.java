package cn.catguild.repository;

import cn.catguild.domain.Travel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.repository
 * @description
 * @date Created in 2020-09-09 02:01
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Repository
public interface TravelRepository extends ReactiveCrudRepository<Travel,String> {
}
