package cn.catguild.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.utils
 * @description
 * @date Created in 2021-04-24 09:43
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
public class BeanUtil {

	/**
	 * 对象缓存
	 */
	private final static Map<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();

	public static void copy(Object source, Object target) {
		// 先从缓存中获取
		String key = source.getClass().getName() + ":" + target.getClass().getName();
		BeanCopier beanCopier;
		if (beanCopierCache.containsKey(key)) {
			beanCopier = beanCopierCache.get(key);
		} else {
			beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
			beanCopierCache.put(key, beanCopier);
		}
		beanCopier.copy(source, target, null);
	}

}
