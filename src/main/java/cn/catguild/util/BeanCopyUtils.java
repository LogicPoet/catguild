package cn.catguild.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 基于BeanCopier的属性拷贝
 * @date 2020/5/13 11:44
 * <p/>
 */
@Slf4j
public class BeanCopyUtils {

	/**
	 * 创建过的BeanCopier实例放到缓存中，下次可以直接获取，提升性能
	 */
	private static final Map<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

	/**
	 * 该方法没有自定义Converter,简单进行常规属性拷贝
	 *
	 * @param source 源对象
	 * @param target 目标对象
	 */
	public static void copy(Object source, Object target) {
		copy(source, target, false);
	}

	/**
	 * 拷贝对象
	 *
	 * @param source 源对象
	 * @param target 目标对象
	 */
	public static void copy(Object source, Object target, boolean useConverter) {
		String key = getKey(source.getClass(), target.getClass(), useConverter);
		BeanCopier copier;
		// 尝试获取缓存的转换器
		if (!BEAN_COPIERS.containsKey(key)) {
			// 没有则创建
			copier = BeanCopier.create(source.getClass(), target.getClass(), useConverter);
			// 放入缓存
			BEAN_COPIERS.put(key, copier);
		} else {
			copier = BEAN_COPIERS.get(key);
		}

		// 复制属性
		Converter converter = null;
		if (useConverter) {
			String converterKey = getConverterKey(source.getClass(), target.getClass());
			converter = SpringUtil.getBean(converterKey);
		}
		copier.copy(source, target, converter);
	}

	/**
	 * 创建key值
	 *
	 * @param srcClazz
	 * @param destClazz
	 * @param useConverter 是否使用转换器
	 * @return
	 */
	private static String getKey(Class<?> srcClazz, Class<?> destClazz, boolean useConverter) {
		return srcClazz.getName() + "-" + destClazz.getName() + "-" + useConverter;
	}

	/**
	 * 创建转换器名值
	 *
	 * @param srcClazz
	 * @param destClazz
	 * @return
	 */
	private static String getConverterKey(Class<?> srcClazz, Class<?> destClazz) {
		String srcName = srcClazz.getSimpleName();
		String destName = destClazz.getSimpleName();
		srcName = toLowerCaseFirstOne(srcName);
		return srcName + "To" + destName + "Converter";
	}

	/**
	 * 字符串首字母转小写
	 *
	 * @param s
	 * @return
	 */
	private static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return Character.toLowerCase(s.charAt(0)) + s.substring(1);
		}
	}

}
