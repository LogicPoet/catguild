package cn.catguild.security.repository;


import cn.catguild.security.model.User;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * <p>
 * 用户 DAO
 * </p>
 *
 * <p>
 * 简单查询关键字解释
 * #n1ql.selectEntity 允许轻松地确保该语句将选择构建完整实体所需的所有字段（包括文档ID和CAS值）。
 *
 * #n1ql.filter 在WHERE子句中添加了一个条件，该条件将实体类型与Spring Data用于存储类型信息的字段相匹配。
 *
 * #n1ql.bucket 将替换为存储实体的存储桶的名称，并在反引号中进行转义。
 *
 * #n1ql.fields 将由重建实体所需的字段列表（例如SELECT子句）替换。
 *
 * #n1ql.delete将由该delete from语句代替。
 *
 * #n1ql.returning 将由重建实体所需的return子句代替。
 * </p>
 *
 * @package: com.xkcoding.rbac.security.repository
 * @description: 用户 DAO
 * @author: yangkai.shen
 * @date: Created in 2018-12-07 16:18
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface UserDao extends ReactiveCouchbaseRepository<User, Long> {

	/**
	 * 使用 N1QL 语法的findAll查询速度更快
	 * @return
	 */
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter}")
	Flux<User> findAllCountries();

	/**
	 * 根据用户名、邮箱、手机号查询用户
	 *
	 * @param username 用户名
	 * @param email    邮箱
	 * @param phone    手机号
	 * @return 用户信息
	 */
	Mono<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);

	/**
	 * 根据用户名列表查询用户列表
	 *
	 * @param usernameList 用户名列表
	 * @return 用户列表
	 */
	@Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} " +
		"AND username in $1")
	Flux<User> findByUsernameIn(List<String> usernameList);


	@Query("#{#n1ql.delete} WHERE #{#n1ql.filter} AND " +
		"username = $1 #{#n1ql.returning}")
	Mono<User> removeUser(String username);

}
