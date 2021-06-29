package cn.catguild.domain.entity;

import cn.catguild.domain.vo.UserSave;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static org.assertj.core.api.Assertions.assertThat;

public class UserSaveAggregator implements ArgumentsAggregator {

	/**
	 * username         varchar(64) NOT NULL,
	 * password         varchar(64) NOT NULL,
	 * real_name        varchar(32) NOT NULL,
	 * nick_name        varchar(32) NOT NULL,
	 * sex              int2,
	 * age              int2,
	 *
	 * @param arguments
	 * @param context
	 * @return
	 */
	@Override
	public UserSave aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
		// 参数校验
		assertNotNull(arguments);
		UserSave userSave = new UserSave();
		userSave.setUsername(arguments.getString(0));
		userSave.setPassword(arguments.getString(1));
		userSave.setRealName(arguments.getString(2));
		userSave.setNickName(arguments.getString(3));
		userSave.setSex(arguments.getInteger(4));
		userSave.setAge(arguments.getInteger(5));
		return userSave;
	}
}
