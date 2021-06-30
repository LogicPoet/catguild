package cn.catguild.repository;

import cn.catguild.ApplicationTest;
import cn.catguild.domain.document.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class PostRepositoryTest extends ApplicationTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	public void findAll(){
		postRepository.findAll();
	}

	@Test
	public void save(){
		Post post = new Post();
		post.setPostId("1");
		Mono<Post> save = postRepository.save(post);
		System.out.println(save.block());
	}

	@Test
	public void findById(){
		Post post = new Post();
		post.setPostId("1");
		Mono<Post> save = postRepository.findById("post_1");
		System.out.println(save.block());
	}

	@Test
	public void deleteAll(){
		Mono<Void> voidMono = postRepository.deleteAll();
		System.out.println(voidMono.block());
	}


}
