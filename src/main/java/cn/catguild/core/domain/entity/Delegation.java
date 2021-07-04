package cn.catguild.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 委托表实体类
 *
 * @author
 * @since 2021-07-03
 */
@Data
@TableName("cat_delegation")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Delegation对象", description = "委托表")
public class Delegation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;
	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型")
	private Integer type;
	/**
	 * 摘要
	 */
	@ApiModelProperty(value = "摘要")
	private String digest;
	/**
	 * 委托内容
	 */
	@ApiModelProperty(value = "委托内容")
	private String content;
	/**
	 * 报酬内容
	 */
	@ApiModelProperty(value = "报酬内容")
	private String reward;
	/**
	 * 任务目标
	 */
	@ApiModelProperty(value = "任务目标")
	private String target;
	/**
	 * 最后期限
	 */
	@ApiModelProperty(value = "最后期限")
	private Long deadline;
	/**
	 * 全局唯一资源id
	 */
	@ApiModelProperty(value = "全局唯一资源id")
	private Long onlyId;

}
