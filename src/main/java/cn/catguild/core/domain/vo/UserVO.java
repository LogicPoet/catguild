package cn.catguild.core.domain.vo;

import cn.catguild.core.domain.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表视图实体类
 *
 * @author
 * @since 2021-07-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserVO对象", description = "用户表")
public class UserVO extends User {
	private static final long serialVersionUID = 1L;

}