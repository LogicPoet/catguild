package cn.catguild.service.impl;

import cn.catguild.domain.base.BaseEntity;
import cn.catguild.service.BaseService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.service.impl
 * @description
 * @date Created in 2021-04-24 12:52
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

	//@Override
	//public boolean save(T entity) {
	//	BladeUser user = SecureUtil.getUser();
	//	if (user != null) {
	//		entity.setCreateUser(user.getUserId());
	//		entity.setUpdateUser(user.getUserId());
	//	}
	//	Date now = DateUtil.now();
	//	entity.setCreateTime(now);
	//	entity.setUpdateTime(now);
	//	if (entity.getStatus() == null) {
	//		entity.setStatus(BladeConstant.DB_STATUS_NORMAL);
	//	}
	//	entity.setIsDeleted(BladeConstant.DB_NOT_DELETED);
	//	return super.save(entity);
	//}

	//@Override
	//public boolean updateById(T entity) {
	//	BladeUser user = SecureUtil.getUser();
	//	if (user != null) {
	//		entity.setUpdateUser(user.getUserId());
	//	}
	//	entity.setUpdateTime(DateUtil.now());
	//	return super.updateById(entity);
	//}

	//@Override
	//public boolean deleteLogic(@NotEmpty List<Long> ids) {
	//	return super.removeByIds(ids);
	//}

}
