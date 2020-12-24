package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author liu.zhi
 * @date 2020/12/24 13:49
 */
@Document
@Data
@EqualsAndHashCode(callSuper = false)
public class Adventurer extends BaseEntity {

	// 冒险家id
	@Id
	private String id;

	// 用户名（后台登陆凭证）
	private String username;

	// 密码
	private String password;

	// 姓名
	private String name;

	// 性别
	private Short sex;

	// 年龄
	private Short age;

	// 身份id
	private String idCard;

	// 注册时间
	private Long registerTime;

	// 账号状态
	private Short status;

}
