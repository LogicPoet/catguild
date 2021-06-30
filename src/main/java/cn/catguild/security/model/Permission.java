package cn.catguild.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * <p>
 * 权限
 * </p>
 *
 * @package: com.xkcoding.rbac.security.model
 * @description: 权限
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 16:04
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Document
public class Permission {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 权限名
     */
    @Field
    private String name;

    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
	@Field
    private String url;

    /**
     * 权限类型，页面-1，按钮-2
     */
	@Field
    private Integer type;

    /**
     * 权限表达式
     */
	@Field
    private String permission;

    /**
     * 后端接口访问方式
     */
	@Field
    private String method;

    /**
     * 排序
     */
	@Field
    private Integer sort;

    /**
     * 父级id
     */
	@Field
    private Long parentId;
}
