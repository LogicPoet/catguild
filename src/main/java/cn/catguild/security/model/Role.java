package cn.catguild.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * <p>
 * 角色
 * </p>
 *
 * @package: com.xkcoding.rbac.security.model
 * @description: 角色
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 15:45
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Document
public class Role {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 角色名
     */
    @Field
    private String name;

    /**
     * 描述
     */
	@Field
    private String description;

    /**
     * 创建时间
     */
	@Field
    private Long createTime;

    /**
     * 更新时间
     */
	@Field
    private Long updateTime;
}
