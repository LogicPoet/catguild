package cn.catguild.exception;

/**
 * @author liu.zhi
 * @date 2020/12/21 11:13
 */
public class AuthException extends RuntimeException{

	public AuthException(){

	}

	/**
	 * 设置 异常消息
	 * @param message 消息
	 */
	public AuthException(String message){
		super(message);
	}

}
