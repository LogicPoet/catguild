package cn.catguild.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 字符串工具
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.utils
 * @description
 * @date Created in 2021-04-24 09:40
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
public class StringUtil extends StringUtils {

	/**
	 * 判断字符串是否为空
	 * <p>
	 * StringUtil.isBlank(null) = false
	 * StringUtil.isBlank("") = false
	 * StringUtil.isBlank(" ") = true
	 * StringUtil.isBlank("Hello") = true
	 *
	 * @param str 字符串
	 * @return 既不是 null 也不是 “” 返回true
	 */
	public static boolean isBlank(@Nullable String str) {
		return hasLength(str);
	}

	/**
	 * 判断字符串是否为空
	 * <p>
	 * StringUtil.isBlank(null) = false
	 * StringUtil.isBlank("") = false
	 * StringUtil.isBlank(" ") = true
	 * StringUtil.isBlank("Hello") = true
	 *
	 * @param str 字符串
	 * @return 既不是 null 也不是 “” 返回true
	 */
	public static boolean isBlank(@Nullable CharSequence str) {
		return hasLength(str);
	}

	/**
	 * 判断输入字符是否都不为空
	 *
	 * @param str 字符串
	 * @return
	 */
	public static boolean isAllBlank(@Nullable String... str) {
		if (null == str) {
			return false;
		}
		for (int i = 0; i < str.length; i++) {
			if (!isBlank(str[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断输入字符是否都不为空
	 *
	 * @param str 字符串
	 * @return
	 */
	public static boolean isAllBlank(@Nullable CharSequence... str) {
		if (null == str) {
			return false;
		}
		for (int i = 0; i < str.length; i++) {
			if (!isBlank(str[i])) {
				return false;
			}
		}
		return true;
	}

}
