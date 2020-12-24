package cn.catguild.controller;

import cn.catguild.ApplicationTest;
import cn.catguild.common.api.R;
import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.EntrustQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class EntrustControllerTest extends ApplicationTest {

	@Autowired
	EntrustController controller;

	@Test
	public void submit() {
	}

	@Test
	public void page() {
		Mono<R<List<Entrust>>> page = controller.page(new EntrustQuery(){{setId("5fe43042daa27c0c5e56f76e");}});
		log.debug("分页结果：{}",page.block().getData());
	}

	@Test
	public void detail() {
	}

	@Test
	public void update() {
	}
}
