package cn.catguild.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.config
 * @description
 * @date Created in 2020-09-09 00:18
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Configuration
public class CbConfig extends AbstractCouchbaseConfiguration {
	/**
	 * The connection string which allows the SDK to connect to the cluster.
	 * <p>
	 * Note that the connection string can take many forms, in its simplest it is just a single hostname
	 * like "127.0.0.1". Please refer to the couchbase Java SDK documentation for all the different
	 * possibilities and options.
	 */
	@Override
	public String getConnectionString() {
		return "couchbase://192.168.134.132";
	}

	/**
	 * The username of the user accessing Couchbase, configured on the cluster.
	 */
	@Override
	public String getUserName() {
		return "admin";
	}

	/**
	 * The password used or the username to authenticate against the cluster.
	 */
	@Override
	public String getPassword() {
		return "123456";
	}

	/**
	 * The name of the bucket that should be used (for example "travel-sample").
	 */
	@Override
	public String getBucketName() {
		return "travel-sample";
	}

}
