package cn.catguild.common;

/**
 * <p>
 * 枚举常见的返回码
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.common
 * @description
 * @date Created in 2021-06-03 20:59
 * @copyright Copyright (c) 2021
 * @modified zhi.liu
 */
public enum ResultCode implements IResultCode {
	SUCCESS(200, "操作成功"),
	FAILURE(400, "业务异常"),
	UN_AUTHORIZED(401, "请求未授权"),
	NOT_FOUND(404, "404 没找到请求"),
	MSG_NOT_READABLE(400, "消息不能读取"),
	METHOD_NOT_SUPPORTED(405, "不支持当前请求方法"),
	MEDIA_TYPE_NOT_SUPPORTED(415, "不支持当前媒体类型"),
	REQ_REJECT(403, "请求被拒绝"),
	INTERNAL_SERVER_ERROR(500, "服务器异常"),
	PARAM_MISS(400, "缺少必要的请求参数"),
	PARAM_TYPE_ERROR(400, "请求参数类型错误"),
	PARAM_BIND_ERROR(400, "请求参数绑定错误"),
	PARAM_VALID_ERROR(400, "参数校验失败"),

	// 自定义返回码
	UNIQUE_VALID_ERROR(2000, "数据唯一性冲突");

	final int code;
	final String message;

	private ResultCode(final int code, final String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
