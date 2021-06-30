package cn.catguild.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * <p>
 * 用户
 * </p>
 *
 * @package: com.xkcoding.rbac.security.model
 * @description: 用户
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 16:00
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@Document
public class User {

    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户名
     */
	@Field
    private String username;

    /**
     * 密码
     */
	@Field
    private String password;

    /**
     * 昵称
     */
	@Field
    private String nickname;

    /**
     * 手机
     */
	@Field
    private String phone;

    /**
     * 邮箱
     */
	@Field
    private String email;

    /**
     * 生日
     */
	@Field
    private Long birthday;

    /**
     * 性别，男-1，女-2
     */
	@Field
    private Integer sex;

    /**
     * 状态，启用-1，禁用-0
     */
	@Field
    private Integer status;

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
