package cn.catguild.domain.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础实体类
 *
 * @author liu.zhi
 * @date 2020/12/11 17:41
 */
@Data
public class BaseEntity implements Serializable {

	// 创建人
	private Long crateUser;

	// 创建时间戳
	private Long crateTimestamp;

	// 更新人
	private Integer updateUser;

	// 更新时间戳
	private Integer updateTimestamp;

	// 是否删除[0:未删除,1:已删除]
	@TableLogic
	private Integer isDeleted;
}
