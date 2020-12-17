package cn.catguild.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author liu.zhi
 * @date 2020/12/17 14:58
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

	/**
	 * 操作成功
	 */
	SUCCESS(HttpStatus.OK.value(), "操作成功"),

	/**
	 * 业务异常
	 */
	FAILURE(HttpStatus.BAD_REQUEST.value(), "业务异常"),

	/**
	 * 请求未授权
	 */
	UN_AUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "请求未授权"),

	/**
	 * 404 没找到请求
	 */
	NOT_FOUND(HttpStatus.NOT_FOUND.value(), "404 没找到请求"),

	/**
	 * 消息不能读取
	 */
	MSG_NOT_READABLE(HttpStatus.BAD_REQUEST.value(), "消息不能读取"),

	/**
	 * 不支持当前请求方法
	 */
	METHOD_NOT_SUPPORTED(HttpStatus.METHOD_NOT_ALLOWED.value(), "不支持当前请求方法"),

	/**
	 * 不支持当前媒体类型
	 */
	MEDIA_TYPE_NOT_SUPPORTED(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "不支持当前媒体类型"),

	/**
	 * 请求被拒绝
	 */
	REQ_REJECT(HttpStatus.FORBIDDEN.value(), "请求被拒绝"),

	/**
	 * 服务器异常
	 */
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器异常"),

	/**
	 * 缺少必要的请求参数
	 */
	PARAM_MISS(HttpStatus.BAD_REQUEST.value(), "缺少必要的请求参数"),

	/**
	 * 请求参数类型错误
	 */
	PARAM_TYPE_ERROR(HttpStatus.BAD_REQUEST.value(), "请求参数类型错误"),

	/**
	 * 请求参数绑定错误
	 */
	PARAM_BIND_ERROR(HttpStatus.BAD_REQUEST.value(), "请求参数绑定错误"),

	/**
	 * 参数校验失败
	 */
	PARAM_VALID_ERROR(HttpStatus.BAD_REQUEST.value(), "参数校验失败"),
	;

	/**
	 * code编码
	 */
	final int code;
	/**
	 * 中文信息描述
	 */
	final String message;

}
