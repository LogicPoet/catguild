package cn.catguild.repository;

import cn.catguild.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TravelRepositoryTest extends ApplicationTest {

	@Autowired
	TravelRepository repository;

	@Test
	public void findAll(){
		repository.findAll();
	}

}
