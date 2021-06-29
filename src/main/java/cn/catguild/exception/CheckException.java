package cn.catguild.exception;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.exception
 * @description
 * @date Created in 2021-06-04 11:14
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
public class CheckException extends RuntimeException {

	public CheckException() {

	}

	/**
	 * 设置 异常消息
	 *
	 * @param message 消息
	 */
	public CheckException(String message) {
		super(message);
	}
}
