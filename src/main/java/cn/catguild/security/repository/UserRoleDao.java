package cn.catguild.security.repository;


import cn.catguild.security.model.UserRole;
import cn.catguild.security.model.unionkey.UserRoleKey;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

/**
 * <p>
 * 用户角色 DAO
 * </p>
 *
 * @package: com.xkcoding.rbac.security.repository
 * @description: 用户角色 DAO
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 11:24
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface UserRoleDao extends ReactiveCouchbaseRepository<UserRole, UserRoleKey>{

}
