package cn.catguild.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表实体类
 *
 * @author
 * @since 2021-07-03
 */
@Data
@TableName("cat_user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User对象", description = "用户表")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 登录名
	 */
	@ApiModelProperty(value = "登录名")
	private String username;
	/**
	 * 登录密码
	 */
	@ApiModelProperty(value = "登录密码")
	private String password;
	/**
	 * 真实姓名
	 */
	@ApiModelProperty(value = "真实姓名")
	private String realName;
	/**
	 * 昵称
	 */
	@ApiModelProperty(value = "昵称")
	private String nickName;
	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	private Integer gender;
	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	private Integer age;
	/**
	 * 全局唯一资源id
	 */
	@ApiModelProperty(value = "全局唯一资源id")
	private Long onlyId;


}
