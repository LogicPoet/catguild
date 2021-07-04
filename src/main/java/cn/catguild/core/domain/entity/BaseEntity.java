package cn.catguild.core.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhi.liu
 * @date 2021-07-02 17:16
 */
@Data
public class BaseEntity {
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private Integer status;
	/**
	 * 创建日期
	 */
	@ApiModelProperty(value = "创建日期")
	@TableField(fill = FieldFill.INSERT)
	private Long createTime;
	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private Long createUser;

	/**
	 * 更新日期
	 */
	@ApiModelProperty(value = "更新日期")
	@TableField(fill = FieldFill.UPDATE)
	private Long updateTime;

	/**
	 * 更新人
	 */
	@ApiModelProperty(value = "更新人")
	private Long updateUser;

	/**
	 * 逻辑删除字段
	 */
	@ApiModelProperty(value = "逻辑删除字段")
	@TableLogic
	@TableField(select = false)
	private Long deletedTime;

	/**
	 * 版本号乐观锁
	 */
	@ApiModelProperty(value = "版本号乐观锁")
	@Version
	private Integer version;

}
