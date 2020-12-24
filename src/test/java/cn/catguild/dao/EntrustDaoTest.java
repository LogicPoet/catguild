package cn.catguild.dao;

import cn.catguild.ApplicationTest;
import cn.catguild.domain.entity.Entrust;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class EntrustDaoTest  extends ApplicationTest {

	@Autowired
	EntrustDao entrustDao;

	@Test
	public void findAll(){
		Entrust entrust = new Entrust();
		entrust.setId("qqq");
		Flux<Entrust> all = entrustDao.findAll(Example.of(entrust));
		List<Entrust> block = all.collectList().block();
		if (null == block || block.isEmpty()){
			log.debug("查询结果为空");
		}else {
			for (Entrust entrustr : block) {
				log.debug("查询结果：{}",entrustr.getId());
			}
		}
	}

}
