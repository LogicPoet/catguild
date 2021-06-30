package cn.catguild.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

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
    private Long id;

	/**
	 * 角色id
	 */
	@Field
	private Long roleId;

	/**
	 * 权限id
	 */
	@Field
	private Long permissionId;
}
