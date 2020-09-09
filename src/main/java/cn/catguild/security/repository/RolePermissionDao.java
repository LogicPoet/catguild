package cn.catguild.security.repository;


import cn.catguild.security.model.RolePermission;
import cn.catguild.security.model.unionkey.RolePermissionKey;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

/**
 * <p>
 * 角色-权限 DAO
 * </p>
 *
 * @package: com.xkcoding.rbac.security.repository
 * @description: 角色-权限 DAO
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 13:45
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface RolePermissionDao extends ReactiveCouchbaseRepository<RolePermission, RolePermissionKey>{
}
