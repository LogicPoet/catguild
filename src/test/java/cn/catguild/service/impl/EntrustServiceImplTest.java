package cn.catguild.service.impl;

import cn.catguild.ApplicationTest;
import cn.catguild.dao.EntrustDao;
import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.EntrustQuery;
import cn.catguild.service.EntrustService;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

@Slf4j
public class EntrustServiceImplTest extends ApplicationTest {

	@Autowired
	EntrustService service;

	@Test
	public void submit() {
	}

	@Test
	public void page() {
	}

	@Test
	public void detail() {
		EntrustQuery query = new EntrustQuery();
		query.setId("5fe43042daa27c0c5e56f76e");
		Mono<Entrust> detail = service.detail(query);
		log.debug("详情：{}",detail.block());
	}

	@Test
	public void update() {
	}
}
