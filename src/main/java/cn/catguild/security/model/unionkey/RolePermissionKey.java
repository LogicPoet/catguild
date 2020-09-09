package cn.catguild.security.model.unionkey;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.io.Serializable;

/**
 * <p>
 * 角色-权限联合主键
 * </p>
 *
 * @package: com.xkcoding.rbac.security.model.unionkey
 * @description: 角色-权限联合主键
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 13:47
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Document
public class RolePermissionKey implements Serializable {
    private static final long serialVersionUID = 6850974328279713855L;

    /**
     * 角色id
     */
    @Id
    private Long roleId;

    /**
     * 权限id
     */
    @Field
    private Long permissionId;
}
