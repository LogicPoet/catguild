package cn.catguild.service.impl;

import cn.catguild.domain.entity.User;
import cn.catguild.domain.vo.UserSave;
import cn.catguild.domain.vo.UserVO;
import cn.catguild.exception.CheckException;
import cn.catguild.mapper.UserMapper;
import cn.catguild.service.IUserService;
import cn.catguild.utils.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用户表 服务实现类
 *
 * @author
 * @since 2021-06-01
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

	private final ReentrantLock checkUsernameLock = new ReentrantLock();


	@Override
	public List<UserVO> getPage(String keyword, IPage<User> page) {
		return null;
	}

	@Override
	public boolean register(UserSave userSave) {
		try {
			checkUsernameLock.lock();
			// 数据唯一性校验
			boolean check = checkUserName(null, userSave.getUsername());
			if (check) {
				throw new CheckException("用户名重复");
			}

			// 添加用户
			User user = new User();
			BeanUtil.copy(userSave, user);
			int insert = baseMapper.insert(user);
			userSave.setId(user.getId());
			return SqlHelper.retBool(insert);
		} finally {
			checkUsernameLock.unlock();
		}
	}

	@Override
	public boolean logout(List<Integer> userIds) {
		try {
			checkUsernameLock.lock();
			// 注销用户
			int insert = baseMapper.deleteBatchIds(userIds);
			return SqlHelper.retBool(insert);
		} finally {
			checkUsernameLock.unlock();
		}
	}

	/**
	 * 校验用户名是否唯一
	 *
	 * @param username 登录名
	 * @param userId   用户主键
	 * @return 是否唯一
	 */
	private boolean checkUserName(Integer userId, String username) {
		LambdaQueryWrapper<User> eq = Wrappers.<User>lambdaQuery().eq(User::getUsername, username);
		if (!ObjectUtils.isEmpty(userId)) {
			eq.ne(User::getId, userId);
		}
		Integer count = baseMapper.selectCount(eq);
		return !SqlHelper.retBool(count);
	}

}
