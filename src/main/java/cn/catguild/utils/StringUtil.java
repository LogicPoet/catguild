package cn.catguild.utils;

import org.springframework.lang.Nullable;

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
public class StringUtil extends org.springframework.util.StringUtils {

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
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @return
	 */
	public static boolean isAllBlank(@Nullable CharSequence str1, @Nullable CharSequence str2) {
		return isBlank(str1) && isBlank(str2);
	}

	/**
	 * 判断输入字符是否都不为空
	 *
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @param str3 字符串3
	 * @return
	 */
	public static boolean isAllBlank(@Nullable CharSequence str1,
									 @Nullable CharSequence str2,
									 @Nullable CharSequence str3) {
		return isBlank(str1) && isBlank(str2) && isBlank(str3);
	}

}
