package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 任务表表实体类
 *
 * @author
 * @since 2021-06-01
 */
@Data
@TableName("cat_task")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Task对象", description = "任务表表")
public class Task extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;
	/**
	 * 摘要
	 */
	@ApiModelProperty(value = "摘要")
	private String digest;
	/**
	 * 详细内容
	 */
	@ApiModelProperty(value = "详细内容")
	private String detail;
	/**
	 * 奖励金额
	 */
	@ApiModelProperty(value = "奖励金额")
	private BigDecimal reward;
	/**
	 * 截止时间
	 */
	@ApiModelProperty(value = "截止时间")
	private Long deadline;
	/**
	 * 任务目标
	 */
	@ApiModelProperty(value = "任务目标")
	private String target;
	/**
	 * 任务状态[详情见字典表]
	 */
	@ApiModelProperty(value = "任务状态[详情见字典表]")
	private Integer status;


}
