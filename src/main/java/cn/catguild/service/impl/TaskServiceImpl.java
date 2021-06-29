package cn.catguild.service.impl;

import cn.catguild.domain.entity.Task;
import cn.catguild.mapper.TaskMapper;
import cn.catguild.service.ITaskService;
import org.springframework.stereotype.Service;

/**
 * 任务表表 服务实现类
 *
 * @author
 * @since 2021-06-01
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<TaskMapper, Task> implements ITaskService {


}
