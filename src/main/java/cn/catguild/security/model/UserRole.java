package cn.catguild.security.model;

import cn.catguild.security.model.unionkey.UserRoleKey;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * <p>
 * 用户角色关联
 * </p>
 *
 * @package: com.xkcoding.rbac.security.model
 * @description: 用户角色关联
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 11:18
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Document
public class UserRole {
    /**
     * 主键
     */
    @Id
    private UserRoleKey id;
}
