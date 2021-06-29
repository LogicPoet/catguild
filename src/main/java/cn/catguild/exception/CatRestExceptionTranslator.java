//package cn.catguild.exception;
//
//import cn.catguild.common.api.R;
//import cn.catguild.common.api.ResultCode;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import reactor.core.publisher.Mono;
//
///**
// * @author liu.zhi
// * @date 2020/12/21 14:29
// */
//@Slf4j
//@Configuration
////@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
////@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
//@RestControllerAdvice
//public class CatRestExceptionTranslator {
//
//	//@ExceptionHandler(MissingServletRequestParameterException.class)
//	//@ResponseStatus(HttpStatus.BAD_REQUEST)
//	//public R handleError(MissingServletRequestParameterException e) {
//	//	log.warn("缺少请求参数", e.getMessage());
//	//	String message = String.format("缺少必要的请求参数: %s", e.getParameterName());
//	//	return R.fail(ResultCode.PARAM_MISS, message);
//	//}
//
//	@ExceptionHandler(AuthException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public Mono<R> handleError(AuthException e) {
//		log.warn("授权错误,{}", e.getMessage());
//		return Mono.just("").map(s-> R.fail(ResultCode.PARAM_TYPE_ERROR, e.getMessage()));
//	}
//
//	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public R handleError(MethodArgumentTypeMismatchException e) {
//		log.warn("请求参数格式错误,{}", e.getMessage());
//		String message = String.format("请求参数格式错误: %s", e.getName());
//		return R.fail(ResultCode.PARAM_TYPE_ERROR, message);
//	}
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public R handleError(MethodArgumentNotValidException e) {
//		log.warn("参数验证失败,{}", e.getMessage());
//		return handleError(e.getBindingResult());
//	}
//
//	@ExceptionHandler(BindException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public R handleError(BindException e) {
//		log.warn("参数绑定失败,{}", e.getMessage());
//		return handleError(e.getBindingResult());
//	}
//
//	private R handleError(BindingResult result) {
//		FieldError error = result.getFieldError();
//		String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
//		return R.fail(ResultCode.PARAM_BIND_ERROR, message);
//	}
//
//	//@ExceptionHandler(ConstraintViolationException.class)
//	//@ResponseStatus(HttpStatus.BAD_REQUEST)
//	//public R handleError(ConstraintViolationException e) {
//	//	log.warn("参数验证失败", e.getMessage());
//	//	Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//	//	ConstraintViolation<?> violation = violations.iterator().next();
//	//	String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
//	//	String message = String.format("%s:%s", path, violation.getMessage());
//	//	return R.fail(ResultCode.PARAM_VALID_ERROR, message);
//	//}
//
//	//@ExceptionHandler(NoHandlerFoundException.class)
//	//@ResponseStatus(HttpStatus.NOT_FOUND)
//	//public R handleError(NoHandlerFoundException e) {
//	//	log.error("404没找到请求:{}", e.getMessage());
//	//	return R.fail(ResultCode.NOT_FOUND, e.getMessage());
//	//}
//
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public R handleError(HttpMessageNotReadableException e) {
//		log.error("消息不能读取:{}", e.getMessage());
//		return R.fail(ResultCode.MSG_NOT_READABLE, e.getMessage());
//	}
//
//	//@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	//@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//	//public R handleError(HttpRequestMethodNotSupportedException e) {
//	//	log.error("不支持当前请求方法:{}", e.getMessage());
//	//	return R.fail(ResultCode.METHOD_NOT_SUPPORTED, e.getMessage());
//	//}
//
//	//@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//	//@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//	//public R handleError(HttpMediaTypeNotSupportedException e) {
//	//	log.error("不支持当前媒体类型:{}", e.getMessage());
//	//	return R.fail(ResultCode.MEDIA_TYPE_NOT_SUPPORTED, e.getMessage());
//	//}
//
//	//@ExceptionHandler(ServiceException.class)
//	//@ResponseStatus(HttpStatus.BAD_REQUEST)
//	//public R handleError(ServiceException e) {
//	//	log.error("业务异常", e);
//	//	return R.fail(e.getResultCode(), e.getMessage());
//	//}
//
//	//@ExceptionHandler(SecureException.class)
//	//@ResponseStatus(HttpStatus.UNAUTHORIZED)
//	//public R handleError(SecureException e) {
//	//	log.error("认证异常", e);
//	//	return R.fail(e.getResultCode(), e.getMessage());
//	//}
//
//	//@ExceptionHandler(Throwable.class)
//	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	//public R handleError(Throwable e) {
//	//	log.error("服务器异常", e);
//	//	//发送服务异常事件
//	//	ErrorLogPublisher.publishEvent(e, UrlUtil.getPath(WebUtil.getRequest().getRequestURI()));
//	//	return R.fail(ResultCode.INTERNAL_SERVER_ERROR, (Func.isEmpty(e.getMessage()) ? ResultCode.INTERNAL_SERVER_ERROR.getMessage() : e.getMessage()));
//	//}
//
//}
