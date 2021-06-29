package cn.catguild.common;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.common
 * @description
 * @date Created in 2021-06-02 21:27
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
class VariableArgumentsProvider
	implements ArgumentsProvider, AnnotationConsumer<VariableSource> {

	private String variableName;

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		return context.getTestClass()
			.map(this::getField)
			.map(this::getValue)
			.orElseThrow(() ->
				new IllegalArgumentException("Failed to load test arguments"));
	}

	//从注解获取对应的参数名称
	@Override
	public void accept(VariableSource variableSource) {
		variableName = variableSource.value();
	}

	//从测试类根据参数名称获取Field字段信息
	private Field getField(Class<?> clazz) {
		try {
			return clazz.getDeclaredField(variableName);
		} catch (Exception e) {
			return null;
		}
	}

	//获取参数值
	@SuppressWarnings("unchecked")
	private Stream<Arguments> getValue(Field field) {
		Object value = null;
		try {
			field.setAccessible(true);
			value = field.get(null);
		} catch (Exception ignored) {
		}

		return value == null ? null : (Stream<Arguments>) value;
	}
}
