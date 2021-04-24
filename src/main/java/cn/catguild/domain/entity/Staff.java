package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 职员实体
 *
 * @author liu.zhi
 * @date 2020/12/11 16:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Staff extends BaseEntity {

	// 用户id
	private String id;

	// 工号（后台登陆凭证）
	private String jobNumber;

	// 密码
	private String password;

	// 姓名
	private String name;

	// 性别
	private Short sex;

	// 年龄
	private Short age;

}
