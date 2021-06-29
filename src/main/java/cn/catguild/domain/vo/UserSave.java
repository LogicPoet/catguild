package cn.catguild.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 保存一个用户
 * 新建一个类来专门保存对象
 * 优点，1、添加的校验不会影响到与数据库映射的实体类
 * 2、可以灵活选择参数
 * 缺点，1、与数据库实体类对象的字段映射需要专门维护
 * 2、多冗余了一个对象
 * 3、插入数据时需要进行对象转换（可以考虑手写sql，手动设置参数）
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.domain.vo
 * @description
 * @date Created in 2021-06-03 20:42
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
@Data
public class UserSave implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;

	/**
	 * 登录名
	 */
	@ApiModelProperty(value = "登录名")
	@Size(min = 2, max = 64, message = "登录密码-长度范围[2-64]")
	@Pattern(regexp = "[\\u4e00-\\u9fa5]", message = "登录名-不能输入中文")
	private String username;

	/**
	 * 登录密码
	 */
	@ApiModelProperty(value = "登录密码")
	@Size(min = 6, max = 64, message = "登录密码-长度范围[6-64]")
	@Pattern(regexp = "[\\u4e00-\\u9fa5]", message = "登录密码-不能输入中文")
	private String password;

	/**
	 * 真实姓名
	 */
	@Size(min = 1, max = 64, message = "真实姓名-长度范围[1-32]")
	@ApiModelProperty(value = "真实姓名")
	private String realName;

	/**
	 * 昵称
	 */
	@Size(min = 1, max = 32, message = "昵称-长度范围[1-32]")
	@ApiModelProperty(value = "昵称")
	private String nickName;

	/**
	 * 性别[0:女,1:男]
	 */
	@Size(min = 0, max = 2, message = "性别-取值候选[0|1|2]")
	@ApiModelProperty(value = "性别[0:女,1:男,2:保密]")
	private Integer sex;

	/**
	 * 年龄
	 */
	@Size(min = 15, max = 200, message = "年龄-取值范围[15-200]")
	@ApiModelProperty(value = "年龄")
	private Integer age;

}
