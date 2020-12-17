package cn.catguild.controller;

import cn.catguild.ApplicationTest;
import cn.catguild.dao.StaffDao;
import cn.catguild.domain.entity.Staff;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class StaffControllerTest extends ApplicationTest {

	@Autowired
	StaffController controller;

	@Autowired
	StaffDao staffDao;

	@Autowired
	ReactiveMongoOperations mongoOperations;

	@Test
	public void submit() {
		for (int i = 0; i < 3; i++) {
			Staff staff = new Staff();
			staff.setName("白起");
			staff.setJobNumber("000003");
			staff.setAge((short) 30);
			staff.setSex((short) 2);
			staff.setCrateTime(Instant.now().toEpochMilli());
			try {
				Mono<Staff> submit = controller.submit(staff);
				log.debug("成功保存：{}", submit.block());
			} catch (Exception e) {
				log.error("保存失败：{}", e.getMessage());
			}
		}
	}

	@Test
	public void page() {
		Flux<Staff> page = controller.page();
		log.debug("职员列表：{}",page.collectList().block());
	}

	@Test
	public void remove() {
		List<String> block = controller.page().map(staff -> staff.getId()).collectList().block();
		StringBuilder sb = new StringBuilder();
		for (String s1 : block) {
			sb.append(",");
			sb.append(s1);
		}
		sb.delete(0,1);
		log.debug("删除的id集合：{}",sb.toString());
		Mono<Void> remove = controller.remove(sb.toString());
		//Mono<Void> remove = controller.remove("5fdad41b64c59e6eb73205eb");
		remove.block();
	}

	/**
	 * 删除
	 */
	@Test
	public void deleteById() {
		Mono<Void> voidMono = staffDao.deleteById("5fdaef9703999f2353f170ff");
		voidMono.block();
	}

	/**
	 * 批量删除
	 */
	@Test
	public void deleteAll() {
		List<Staff> block = controller.page().collectList().block();
		assert block != null;
		Mono<Void> voidMono = staffDao.deleteAll(block);
		voidMono.block();
	}


}
