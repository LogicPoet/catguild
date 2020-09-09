package cn.catguild.repository;

import cn.catguild.domain.Post;
import com.couchbase.client.java.Bucket;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.CompositeQueryIndexes;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
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
