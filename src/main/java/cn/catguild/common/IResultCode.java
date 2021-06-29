package cn.catguild.common;

import java.io.Serializable;

/**
 * <p>
 * 统一返回码接口
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.common
 * @description
 * @date Created in 2021-06-03 20:58
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
public interface IResultCode extends Serializable {

	int getCode();

	String getMessage();

}
