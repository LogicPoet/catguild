package cn.catguild.security.repository;

import cn.catguild.security.model.Permission;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * <p>
 * 权限 DAO
 * </p>
 *
 * @package: com.xkcoding.rbac.security.repository
 * @description: 权限 DAO
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 16:21
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface PermissionDao extends ReactiveCouchbaseRepository<Permission, Long> {

    /**
     * 根据角色列表查询权限列表
     *
     * @param ids 角色id列表
     * @return 权限列表
     */
    @Query(value = "#{#n1ql.selectEntity} WHERE #{#n1ql.filter}" +
		"AND sec_role.id = sec_role_permission.role_id " +
		"AND sec_permission.id = sec_role_permission.permission_id " +
		"AND sec_role.id IN (:ids)")
    Flux<Permission> selectByRoleIdList(@Param("ids") List<Long> ids);
}
