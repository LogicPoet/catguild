package cn.catguild.repository;

import cn.catguild.domain.document.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  创建索引语句，需要先建立索引，否则会在执行删除时报错，找不到可用的索引
 *	CREATE INDEX `index-name` ON `buckname`(`_class`)
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.repository
 * @description
 * @date Created in 2020-09-08 23:56
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Repository
public interface PostRepository extends ReactiveCrudRepository<Post,String> {

	//private Bucket bucket;
	//
	//public PostRepository(<PostRepository that extends ReactiveCrudRepository>  repository){
	//	bucket = repository.getCouchbaseOperations().getCouchbaseBucket();
	//	createIndices();
	//}
	//
	//
	//private void createIndices(){
	//
	//	bucket.bucketManager().createN1qlPrimaryIndex(true, false)
	//
	//	bucket.query(N1qlQuery.simple("CREATE INDEX xyz ON `myBucket`(userId) WHERE _class = 'com.example.User'"))
	//}

}
