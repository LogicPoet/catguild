package cn.catguild.security.model;

import cn.catguild.security.model.unionkey.RolePermissionKey;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * <p>
 * 角色-权限
 * </p>
 *
 * @package: com.xkcoding.rbac.security.model
 * @description: 角色-权限
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 13:46
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Document
public class RolePermission {
    /**
     * 主键
     */
   	@Id
    private RolePermissionKey id;
}
