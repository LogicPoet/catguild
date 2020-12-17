package cn.catguild.common.api;

import java.io.Serializable;

/**
 * @author liu.zhi
 * @date 2020/12/17 14:58
 */

public interface IResultCode extends Serializable {

	/**
	 * 消息
	 *
	 * @return String
	 */
	String getMessage();

	/**
	 * 状态码
	 *
	 * @return int
	 */
	int getCode();

}
