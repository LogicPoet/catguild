package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 职员实体
 *
 * @author liu.zhi
 * @date 2020/12/11 16:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document
public class Staff extends BaseEntity {

	// 用户id
	@Id
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

	// 身份id
	private String idCard;

	// 部门id
	private Integer deptId;

	// 入职时间
	private Long entryTime;

	// 离职时间
	private Long resignationTime;

}
