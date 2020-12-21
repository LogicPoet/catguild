package cn.catguild.controller;

import cn.catguild.common.api.R;
import cn.catguild.domain.entity.Entrust;
import cn.catguild.domain.vo.EntrustQuery;
import cn.catguild.domain.vo.EntrustSave;
import cn.catguild.service.EntrustService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 委托 任务
 *
 * @author liu.zhi
 * @date 2020/12/21 17:01
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/entrust")
public class EntrustController {

	private EntrustService entrustService;

	// 创建任务
	@PostMapping
	public Mono<R<String>> submit(@RequestBody EntrustSave entrustSave) {
		return entrustService.submit(entrustSave).map(R::data);
	}

	// 任务列表
	@GetMapping("/page")
	public Mono<R<List<Entrust>>> page(EntrustQuery entrustQuery) {
		return entrustService.page(entrustQuery).collectList().map(R::data);
	}

	// 任务详情
	@GetMapping("/detail")
	public Mono<R<Entrust>> detail(EntrustQuery entrustQuery) {
		return entrustService.detail(entrustQuery).map(R::data);
	}

	// 更新任务
	@PutMapping
	public Mono<R<String>> update(@RequestBody EntrustSave entrustSave) {
		return entrustService.update(entrustSave).map(R::data);
	}

}
