package cn.catguild.service;

import cn.catguild.domain.entity.User;
import cn.catguild.domain.vo.UserSave;
import cn.catguild.domain.vo.UserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 用户表 服务类
 *
 * @author
 * @since 2021-06-01
 */
public interface IUserService extends BaseService<User> {


	/**
	 * 获取分页列表
	 *
	 * @param keyword
	 * @param page
	 * @return
	 */
	List<UserVO> getPage(String keyword, IPage<User> page);

	/**
	 * 注册新用户
	 *
	 * @param userSave 用户信息
	 * @return 是否注册成功
	 */
	boolean register(UserSave userSave);


	/**
	 * 注销用户(删除用户)
	 *
	 * @param userIds 需要注销的用户id集合
	 * @return 是否注销成功
	 */
	boolean logout(List<Integer> userIds);
}
