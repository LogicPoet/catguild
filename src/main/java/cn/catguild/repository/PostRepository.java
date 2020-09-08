package cn.catguild.repository;

import cn.catguild.domain.Post;
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
 * @date Created in 2020-09-08 23:56
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Repository
public interface PostRepository extends ReactiveCrudRepository<Post,Integer> {

}
