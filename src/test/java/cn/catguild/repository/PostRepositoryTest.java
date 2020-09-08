package cn.catguild.repository;

import cn.catguild.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PostRepositoryTest extends ApplicationTest {

	@Autowired
	PostRepository postRepository;

	@Test
	public void findAll(){
		postRepository.findAll();
	}

}
