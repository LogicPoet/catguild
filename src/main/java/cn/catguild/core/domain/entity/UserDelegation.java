package cn.catguild.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户接取委托表实体类
 *
 * @author
 * @since 2021-07-03
 */
@Data
@TableName("cat_user_delegation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserDelegation对象", description = "用户接取委托表")
public class UserDelegation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 委托id
	 */
	@ApiModelProperty(value = "委托id")
	private Long delegationId;


}
