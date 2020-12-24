package cn.catguild.service;

import cn.catguild.domain.entity.Staff;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 职员服务层接口定义
 *
 * @author liu.zhi
 * @date 2020/12/11 17:58
 */
public interface StaffService {

	/**
	 * 保存职员信息
	 *
	 * @param staff 职员信息对象
	 * @return 保存过后的职员信息
	 */
	Mono<Staff> submit(Staff staff);

	/**
	 * 删除职员信息
	 *
	 * @param staffIds 职员id
	 * @return 无返回值
	 */
	Mono<Void> remove(Collection<String> staffIds);

	/**
	 * 分页获取职员信息列表
	 *
	 * @return 职员信息列表
	 */
	Flux<Staff> page();

	/**
	 * 根据职员id获取职员信息
	 *
	 * @param id 职员id
	 * @return 职员信息
	 */
	Mono<Staff> getOne(String id);
}
