package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 任务表表实体类
 *
 * @author
 * @since 2021-06-01
 */
@Data
@TableName("cat_user_task")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserTask对象", description = "任务表表")
public class UserTask extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(value = "用户id")
	private Long userId;
	/**
	 * 任务id
	 */
	@ApiModelProperty(value = "任务id")
	private Long taskId;


}
