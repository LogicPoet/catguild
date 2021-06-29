package cn.catguild.domain.vo;

import cn.catguild.domain.entity.Task;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 任务表表视图实体类
 *
 * @author
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "TaskVO对象", description = "任务表表")
public class TaskVO extends Task {
	private static final long serialVersionUID = 1L;

}
