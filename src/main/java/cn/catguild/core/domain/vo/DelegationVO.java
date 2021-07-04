package cn.catguild.core.domain.vo;

import cn.catguild.core.domain.entity.Delegation;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 委托表视图实体类
 *
 * @author
 * @since 2021-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DelegationVO对象", description = "委托表")
public class DelegationVO extends Delegation {
	private static final long serialVersionUID = 1L;

}
