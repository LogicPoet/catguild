package cn.catguild.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * MongoDB数据库配置
 *
 * @author liu.zhi
 * @date 2020/12/11 17:52
 */
@Configuration
@MapperScan(basePackages = PostgreConfig.PACKAGE, sqlSessionFactoryRef = "pgSqlSessionFactory")
public class PostgreConfig {

	static final String PACKAGE = "cn.catguild.**.mapper";
	private static final String MAPPER_LOCATION = "classpath:cn/catguild/**/mapper/*Mapper.xml";

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name:org.postgresql.Driver}")
	private String driverClass;

	/////////////////////druid参数///////////////////////////////////////////////////
	@Value("${spring.datasource.druid.max-active}")
	private String maxActive;
	@Value("${spring.datasource.druid.initial-size}")
	private String initialSize;
	@Value("${spring.datasource.druid.max-wait}")
	private String maxWait;
	@Value("${spring.datasource.druid.min-idle}")
	private String minIdle;
	@Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
	private String timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
	private String minEvictableIdleTimeMillis;
	@Value("${spring.datasource.druid.validation-query}")
	private String validationQuery;
	@Value("${spring.datasource.druid.test-while-idle}")
	private String testWhileIdle;
	@Value("${spring.datasource.druid.test-on-borrow}")
	private String testOnBorrow;
	@Value("${spring.datasource.druid.test-on-return}")
	private String testOnReturn;
	@Value("${spring.datasource.druid.pool-prepared-statements:true}")
	private String poolPreparedStatements;
	@Value("${spring.datasource.druid.max-open-prepared-statements:20}")
	private String maxOpenPreparedStatements;


	@Bean(name = "pgDataSource")
	public DataSource pgDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driverClass);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(user);
		druidDataSource.setPassword(password);
		druidDataSource.setMaxActive(Integer.parseInt(maxActive));
		druidDataSource.setInitialSize(Integer.parseInt(initialSize));
		druidDataSource.setMaxWait(Integer.parseInt(maxWait));
		druidDataSource.setMinIdle(Integer.parseInt(minIdle));
		druidDataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(timeBetweenEvictionRunsMillis));
		druidDataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(minEvictableIdleTimeMillis));
		druidDataSource.setValidationQuery(validationQuery);
		druidDataSource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
		druidDataSource.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
		druidDataSource.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
		druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(poolPreparedStatements));
		druidDataSource.setMaxOpenPreparedStatements(Integer.parseInt(maxOpenPreparedStatements));
		return druidDataSource;
	}

	@Bean(name = "pgTransactionManager")
	public DataSourceTransactionManager pgTransactionManager() {
		return new DataSourceTransactionManager(pgDataSource());
	}

	@Bean(name = "pgSqlSessionFactory")
	public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("pgDataSource") DataSource pgDataSource) throws Exception {
		//final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		final MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
		sessionFactory.setDataSource(pgDataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
			.getResources(MAPPER_LOCATION));
		// 开启分页拦截器
		sessionFactory.setPlugins(new PaginationInterceptor());
		// 开启map结果集下划线转驼峰
		sessionFactory.setObjectWrapperFactory(new MybatisMapWrapperFactory());
		return sessionFactory.getObject();
	}

}
