package cn.catguild.service.impl;

import cn.catguild.dao.StaffDao;
import cn.catguild.domain.entity.Staff;
import cn.catguild.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	public Mono<Void> remove(Integer staffId) {
		return staffDao.deleteById(staffId);
	}

	@Override
	public Flux<Staff> page() {
		return staffDao.findAll();
	}
}
