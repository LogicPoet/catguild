package cn.catguild.common;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.common
 * @description
 * @date Created in 2021-06-02 21:26
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(VariableArgumentsProvider.class)
public @interface VariableSource {

	/**
	 * The name of the static variable
	 */
	String value();
}
