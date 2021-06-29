package cn.catguild.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * <p>
 * 统一返回api格式
 * {
 * code:
 * data:
 * msg:
 * }
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.common
 * @description
 * @date Created in 2021-06-02 20:02
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
@Data
public class CommonResult<T> {

	private int code;

	private T data;

	private String msg;

	private CommonResult() {
	}

	private CommonResult(T data) {
		this.code = HttpStatus.OK.value();
		this.msg = "操作成功!";
		this.data = data;
	}

	private CommonResult(int code, T data) {
		this.code = code;
		this.msg = "操作成功!";
		this.data = data;
	}

	private CommonResult(int code, T data, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 设置承载数据
	 *
	 * @param data
	 * @return
	 */
	public static <T> CommonResult<T> data(T data) {
		return new CommonResult<T>(data);
	}

	/**
	 * 设置操作是否成功
	 *
	 * @param flag
	 * @return
	 */
	public static <T> CommonResult<T> status(boolean flag) {
		return flag ? new CommonResult<T>(200, null, "操作成功!")
			: new CommonResult<T>(400, null, "操作失败!");
	}

	/**
	 * 失败返回结果
	 *
	 * @param errorCode 错误码
	 */
	public static <T> CommonResult<T> failed(ResultCode errorCode) {
		return new CommonResult<T>(errorCode.getCode(), null, errorCode.getMessage());
	}

	/**
	 * 失败返回结果
	 *
	 * @param successCode 成功码
	 */
	public static <T> CommonResult<T> success(ResultCode successCode) {
		return new CommonResult<T>(successCode.getCode(), null, successCode.getMessage());
	}

	public static <T> CommonResult<T> failed() {
		return failed(ResultCode.SUCCESS);
	}

}
