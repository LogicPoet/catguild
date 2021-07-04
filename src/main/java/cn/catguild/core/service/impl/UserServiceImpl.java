package cn.catguild.core.service.impl;

import cn.catguild.core.domain.entity.User;
import cn.catguild.core.mapper.UserMapper;
import cn.catguild.core.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author
 * @since 2021-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
