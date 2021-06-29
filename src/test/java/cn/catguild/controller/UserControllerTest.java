package cn.catguild.controller;

import cn.catguild.ApplicationTest;
import cn.catguild.common.CommonResult;
import cn.catguild.common.ResultCode;
import cn.catguild.domain.entity.User;
import cn.catguild.domain.entity.UserSaveAggregator;
import cn.catguild.domain.vo.UserSave;
import cn.catguild.mapper.UserMapper;
import cn.catguild.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@Rollback
@Slf4j
class UserControllerTest extends ApplicationTest {

	@Autowired
	UserMapper userMapper;
	@Autowired
	UserController userController;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private TestRestTemplate testRestTemplate;

	@ParameterizedTest
	@CsvFileSource(resources = "/cat-user.csv", numLinesToSkip = 1)
	void postUser(@AggregateWith(UserSaveAggregator.class) UserSave userSave) throws Exception {
		// 构建请求
		CommonResult result = testRestTemplate.postForObject("/user", userSave, CommonResult.class);

		// 参数校验
		if (ObjectUtils.nullSafeEquals(result.getCode(), HttpStatus.OK.value())) {
			UserSave data = JSONUtil.toPojo((Map) result.getData(), UserSave.class);
			// 插入成功
			User user = userMapper.selectById(data.getId());
			Assertions.assertNotNull(user);
			assertEquals(data.getId(), user.getId());
			assertEquals(userSave.getUsername(), user.getUsername());
			assertEquals(userSave.getPassword(), user.getPassword());
			assertEquals(userSave.getRealName(), user.getRealName());
			assertEquals(userSave.getNickName(), user.getNickName());
			assertEquals(userSave.getSex(), user.getSex());
		}
		if (ObjectUtils.nullSafeEquals(result.getCode(), ResultCode.PARAM_VALID_ERROR)) {
			// 校验插入校验

			// 用户名或密码，不能有汉字，有空格，且都不能超过64位
			//String username = arguments.getString(0);
			//assertThat(username).as("用户名，不能有汉字，有空格，且2-64位")
			//	.isNotNull().doesNotContainAnyWhitespaces().doesNotMatch("[\\u4e00-\\u9fa5]");
			//
			//String password = arguments.getString(1);
			//assertThat(password).as("密码，不能有汉字或空格，且是6-64位")
			//	.isNotNull().doesNotContainAnyWhitespaces().doesNotMatch("[\\u4e00-\\u9fa5]");
			//
			//String realName = arguments.getString(2);
			//assertThat(password).as("真实姓名：不能超过32位，不能有空格")
			//	.isNotNull().doesNotContainAnyWhitespaces().hasSizeBetween(0,32);;
			//
			//String nickName = arguments.getString(3);
			//assertThat(password).as("昵称：不能超过32位，不能有空格")
			//	.isNotNull().doesNotContainAnyWhitespaces().hasSizeBetween(0,32);
			//
			//Integer sex = arguments.getInteger(4);
			//Integer age = arguments.getInteger(5);
			//@Size(min = 0,max = 2,message = "性别-取值候选[0|1|2]")
			//	@ApiModelProperty(value = "性别[0:女,1:男,2:保密]")
			//	private Integer sex;
			//
			//	/**
			//	 * 年龄
			//	 */
			//	@Size(min = 15,max = 200,message = "年龄-取值范围[15-200]")
			if (ObjectUtils.nullSafeEquals(result.getMsg(), "性别-取值候选[0|1|2]")) {
				assertThat(userSave.getSex()).as("性别：不为空且只能为0,1,2").isNotNull().isIn(0, 1, 2);
			}

			//assertThat(sex).as("性别：不为空且只能为0,1,2").isNotNull().isIn(0,1,2);
			//assertThat(age).as("年龄：不为空且只能是15-200").isNotNull().isGreaterThan(14).isLessThan(201);
		}
	}

	@Test
	void getUser() {
	}

	@Test
	void putUser() {
	}

	@Test
	void deleteUser() {
	}

	@Test
	void testGetUser() {
	}

	@Test
	void testPutUser() {
	}

	@Test
	void testDeleteUser() {
	}

	//static class UserVOAggregator implements ArgumentsAggregator {
	//	@Override
	//	public UserVO aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
	//		UserVO userVO = new UserVO();
	//		userVO.setUsername(arguments.getString(0));
	//		userVO.setPassword(arguments.getString(1));
	//		userVO.setRealName(arguments.getString(2));
	//		userVO.setNickName(arguments.getString(3));
	//		userVO.setSex(arguments.getInteger(4));
	//		userVO.setAge(arguments.getInteger(5));
	//		return userVO;
	//	}
	//}

}
