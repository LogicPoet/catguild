package cn.develop.tool;

import org.springframework.lang.Nullable;

/**
 * @author LZ
 * @date 2020/4/2 18:30
 **/
public class ObjectUtil extends org.springframework.util.ObjectUtils {

	/**
	 * 判断元素不为空
	 *
	 * @param obj object
	 * @return boolean
	 */
	public static boolean isNotEmpty(@Nullable Object obj) {
		return !ObjectUtil.isEmpty(obj);
	}

}
