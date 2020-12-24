package cn.catguild.controller;

import cn.catguild.common.api.R;
import cn.catguild.domain.entity.Adventurer;
import cn.catguild.domain.vo.AdventurerQuery;
import cn.catguild.domain.vo.AdventurerSave;
import cn.catguild.service.AdventurerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 冒险家控制器
 *
 * @author liu.zhi
 * @date 2020/12/24 13:48
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/adventurer")
public class AdventurerController {

	private AdventurerService adventurerService;

	// 创建任务
	@PostMapping
	public Mono<R<String>> submit(@RequestBody AdventurerSave adventurerSave) {
		return adventurerService.submit(adventurerSave).map(R::data);
	}

	// 任务列表
	@GetMapping("/page")
	public Mono<R<List<Adventurer>>> page(AdventurerQuery adventurerQuery) {
		return adventurerService.page(adventurerQuery).collectList().map(R::data);
	}

	// 任务详情
	@GetMapping("/detail")
	public Mono<R<Adventurer>> detail(AdventurerQuery adventurerQuery) {
		return adventurerService.detail(adventurerQuery).map(R::data);
	}

	// 更新任务
	@PutMapping
	public Mono<R<String>> update(@RequestBody AdventurerSave adventurerSave) {
		return adventurerService.update(adventurerSave).map(R::data);
	}

}
