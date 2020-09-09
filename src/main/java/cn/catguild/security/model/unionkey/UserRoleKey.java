package cn.catguild.security.model.unionkey;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.io.Serializable;

/**
 * <p>
 * 用户-角色联合主键
 * </p>
 *
 * @package com.xkcoding.rbac.security.model.unionkey
 * @description 用户-角色联合主键
 * @author yangkai.shen
 * @date Created in 2018-12-10 11:20
 * @copyright Copyright (c) 2018
 * @version V1.0
 * @modified yangkai.shen
 */
@Data
@Document
public class UserRoleKey implements Serializable {
    private static final long serialVersionUID = 5633412144183654743L;

    /**
     * 用户id
     */
	@Id
    private Long userId;

    /**
     * 角色id
     */
	@Field
    private Long roleId;
}
