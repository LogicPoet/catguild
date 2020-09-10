package cn.catguild.security.repository;

import cn.catguild.security.model.Role;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * <p>
 * 角色 DAO
 * </p>
 *
 * @package: com.xkcoding.rbac.security.repository
 * @description: 角色 DAO
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 16:20
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface RoleDao extends ReactiveCouchbaseRepository<Role, Long>{
    /**
     * 根据用户id 查询角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter}" +
		"AND sec_user.id = sec_user_role.user_id " +
		"AND sec_role.id = sec_user_role.role_id " +
		"AND sec_user.id = :userId")
    Flux<Role> selectByUserId(@Param("userId") Long userId);
}
