package cn.catguild.core.domain.vo;

import cn.catguild.core.domain.entity.UserDelegation;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户接取委托表视图实体类
 *
 * @author
 * @since 2021-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserDelegationVO对象", description = "用户接取委托表")
public class UserDelegationVO extends UserDelegation {
	private static final long serialVersionUID = 1L;

}
