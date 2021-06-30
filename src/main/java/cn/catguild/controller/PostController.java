package cn.catguild.controller;

import cn.catguild.domain.document.Post;
import cn.catguild.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.controller
 * @description
 * @date Created in 2020-09-09 00:38
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@RequestMapping("/post")
@RestController
@AllArgsConstructor
public class PostController {

	private PostRepository postRepository;

	@GetMapping("/all")
	public Flux<Post> getAll(){
		Flux<Post> all = postRepository.findAll();
		return all;
	}

}
