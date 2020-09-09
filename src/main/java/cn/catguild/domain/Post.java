package cn.catguild.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

/**
 * <p>
 * 帖子
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.domain
 * @description 域对象上的主键都不是必要，不写也能工作，但写上可以避免一些未知的极端情况
 * @date Created in 2020-09-08 23:59
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	/**
	 * 长度不超过250个字符(每个bucket内是唯一的)
	 */
	@Id
	@GeneratedValue(strategy = USE_ATTRIBUTES, delimiter = "_")
	private String id;

	@IdPrefix(order = 0)
	private String userPrefix = "post";

	@IdAttribute
	@QueryIndexed
	private String postId;

	@Field
	private String title;

	@CreatedBy
	private String creator;

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate
	private LocalDateTime lastModification;

	@CreatedDate
	private LocalDateTime creationDate;

	@Version
	private long version;


}
