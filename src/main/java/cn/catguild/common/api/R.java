package cn.catguild.common.api;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Optional;

/**
 * 统一API响应结果封装
 *
 * @author Chill
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 默认为空消息
	 */
	private final static String DEFAULT_NULL_MESSAGE = "暂无承载数据";
	/**
	 * 默认成功消息
	 */
	private final static String DEFAULT_SUCCESS_MESSAGE = "操作成功";
	/**
	 * 默认失败消息
	 */
	private final static String DEFAULT_FAILURE_MESSAGE = "操作失败";
	/**
	 * 默认未授权消息
	 */
	private final static String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";

	/**
	 * 状态码
	 */
	private int code;

	/**
	 * 是否成功
	 */
	private boolean success;

	/**
	 * 承载数据
	 */
	private T data;

	/**
	 * 返回消息
	 */
	private String msg;

	private R(IResultCode resultCode) {
		this(resultCode, null, resultCode.getMessage());
	}

	private R(IResultCode resultCode, String msg) {
		this(resultCode, null, msg);
	}

	private R(IResultCode resultCode, T data) {
		this(resultCode, data, resultCode.getMessage());
	}

	private R(IResultCode resultCode, T data, String msg) {
		this(resultCode.getCode(), data, msg);
	}

	private R(int code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.success = ResultCode.SUCCESS.getCode() == code;
	}

	/**
	 * 判断返回是否为成功
	 *
	 * @param result Result
	 * @return 是否成功
	 */
	public static boolean isSuccess(@Nullable R<?> result) {
		return Optional.ofNullable(result)
			.map(x -> ObjectUtil.equal(ResultCode.SUCCESS.getCode(), x.code))
			.orElse(Boolean.FALSE);
	}

	/**
	 * 判断返回是否为成功
	 *
	 * @param result Result
	 * @return 是否成功
	 */
	public static boolean isNotSuccess(@Nullable R<?> result) {
		return !R.isSuccess(result);
	}

	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data) {
		return data(data, DEFAULT_SUCCESS_MESSAGE);
	}

	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data, String msg) {
		return data(HttpStatus.OK.value(), data, msg);
	}

	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param data 数据
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(int code, T data, String msg) {
		return new R<>(code, data, data == null ? DEFAULT_NULL_MESSAGE : msg);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(String msg) {
		return new R<>(ResultCode.SUCCESS, msg);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(IResultCode resultCode) {
		return new R<>(resultCode);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param msg        消息
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(IResultCode resultCode, String msg) {
		return new R<>(resultCode, msg);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(String msg) {
		return new R<>(ResultCode.FAILURE, msg);
	}


	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(int code, String msg) {
		return new R<>(code, null, msg);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(IResultCode resultCode) {
		return new R<>(resultCode);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param msg        消息
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(IResultCode resultCode, String msg) {
		return new R<>(resultCode, msg);
	}

	/**
	 * 返回R
	 *
	 * @param flag 成功状态
	 * @return R
	 */
	public static <T> R<T> status(boolean flag) {
		return flag ? success(DEFAULT_SUCCESS_MESSAGE) : fail(DEFAULT_FAILURE_MESSAGE);
	}

}
