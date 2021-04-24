package cn.catguild.service.impl;

import cn.catguild.domain.entity.Staff;
import cn.catguild.mapper.StaffMapper;
import cn.catguild.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author liu.zhi
 * @date 2020/12/11 17:59
 */
@AllArgsConstructor
@Service
public class StaffServiceImpl extends BaseServiceImpl<StaffMapper, Staff> implements StaffService {


	@Override
	public Mono<Staff> submit(Staff staff) {
		return null;
	}

	@Override
	public Mono<Void> remove(Collection<String> staffIds) {
		return null;
	}

	@Override
	public Flux<Staff> page() {
		return null;
	}

	@Override
	public Mono<Staff> getOne(String id) {
		return null;
	}
}
