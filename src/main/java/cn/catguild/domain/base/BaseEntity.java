package cn.catguild.domain.base;

import lombok.Data;

/**
 * 基础实体类
 *
 * @author liu.zhi
 * @date 2020/12/11 17:41
 */
@Data
public class BaseEntity {

	// 创建时间戳
	private Long crateTime;

	// 更新时间戳
	private Long updateTime;

	// 创建人
	private Integer crateStaff;

	// 修改人
	private Integer updateStaff;

}
