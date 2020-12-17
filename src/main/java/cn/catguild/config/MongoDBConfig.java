package cn.catguild.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;

/**
 * MongoDB数据库配置
 *
 * @author liu.zhi
 * @date 2020/12/11 17:52
 */
@Configuration
public class MongoDBConfig {

	//@Bean
	//public MongoClient reactiveMongoClient() {
	//	return MongoClients.create("mongodb://localhost");
	//}
	//
	//@Bean
	//public ReactiveMongoTemplate reactiveMongoTemplate() {
	//	ReactiveMongoTemplate template = new ReactiveMongoTemplate(reactiveMongoClient(), "catguild_db");
	//	template.setWriteResultChecking(WriteResultChecking.EXCEPTION);
	//	return template;
	//}

}
