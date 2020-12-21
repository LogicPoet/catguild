package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 委托 任务实体
 *
 * @author liu.zhi
 * @date 2020/12/21 17:14
 */
@Document
@Data
@EqualsAndHashCode(callSuper = false)
public class Entrust extends BaseEntity {

	// 任务id
	@Id
	private String id;

	// 任务内容
	private String content;

	// 委托人
	private String principalId;

	// 发布时间
	private String releaseTime;

	// 截止时间
	private String deadline;

}
