package cn.catguild.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * json工具类 依赖于jackson
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.utils
 * @description
 * @date Created in 2021-04-24 09:45
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */

/**
 * Jackson工具类
 *
 * @author Chill
 */
@Slf4j
class JsonUtil {

	/**
	 * 将对象序列化成json字符串
	 *
	 * @param value javaBean
	 * @param <T>   T 泛型标记
	 * @return jsonString json字符串
	 */
	public static <T> String toJson(T value) {
		try {
			return getInstance().writeValueAsString(value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static ObjectMapper getInstance() {
		return JacksonHolder.INSTANCE;
	}

	private static class JacksonHolder {
		private static ObjectMapper INSTANCE = new JsonMapper();
	}

}
