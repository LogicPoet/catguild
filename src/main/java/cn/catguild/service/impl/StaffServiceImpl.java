package cn.catguild.service.impl;

import cn.catguild.dao.StaffDao;
import cn.catguild.domain.entity.Staff;
import cn.catguild.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author liu.zhi
 * @date 2020/12/11 17:59
 */
@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;


	@Override
	public Mono<Staff> submit(Staff staff) {
		return staffDao.save(staff);
	}

	@Override
	public Mono<Void> remove(Collection<String> staffIds) {
		Flux<Staff> staffFlux = Flux.fromIterable(staffIds.stream().map(s -> new Staff() {{
			setId(s);
		}}).collect(Collectors.toList()));
		return staffDao.deleteAll(staffFlux);
	}

	@Override
	public Flux<Staff> page() {
		return staffDao.findAll();
	}
}
