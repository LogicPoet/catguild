package cn.catguild.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * jwt令牌生成工具
 *
 * JSON Web Token由三部分组成，它们之间用圆点(.)连接。这三部分分别是：
 * Header.Payload.Signature
 *
 * header典型的由两部分组成：token的类型（“JWT”）和算法名称（比如：HMAC SHA256或者RSA等等）。
 * 然后，用Base64对这个JSON编码就得到JWT的第一部分
 *
 * JWT的第二部分是payload，它包含声明（要求）。声明是关于实体(通常是用户)和其他数据的声明。声明有三种类型: registered, public 和 private。
 * Registered claims : 这里有一组预定义的声明，它们不是强制的，但是推荐。比如：iss (issuer), exp (expiration time), sub (subject), aud (audience)等。
 * Public claims : 可以随意定义。
 * Private claims : 用于在同意使用它们的各方之间共享信息，并且不是注册的或公开的声明。
 * 对payload进行Base64编码就得到JWT的第二部分
 * 注意，不要在JWT的payload或header中放置敏感信息，除非它们是加密的。
 *
 * 为了得到签名部分，你必须有编码过的header、编码过的payload、一个秘钥，签名算法是header中指定的那个，然对它们签名即可。
 * 例如： HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
 * 签名是用于验证消息在传递过程中有没有被更改，并且，对于使用私钥签名的token，它还可以验证JWT的发送方是否为它所称的发送方。
 *
 * @author liu.zhi
 * @date 2020/12/17 17:33
 */
public class JwtUtil {

	private JwtUtil(){}

	public static String createJwt(String username){
		// Header { "type": "JWT" , "alg": "RSA" }
		String headerStr = "{ \"type\": \"JWT\" , \"alg\": \"hmacMd5\" }";
		String headerB64 = Base64.encode(headerStr);

		// payload
		String payload = "{ \"sub\": \"1234567\" , \"name\": \"李宁\" }";
		String payloadB64 = Base64.encode(payload);

		// Signature
		String s = SecureUtil.md5(headerB64 + "." + payloadB64);
		String signature = Base64.encode(s);
		return headerB64+"."+payloadB64+"."+signature;
	}

	public static void main(String[] args) {
		// Header { "type": "JWT" , "alg": "RSA" }
		String headerStr = "{ \"type\": \"JWT\" , \"alg\": \"hmacMd5\" }";
		String headerB64 = Base64.encode(headerStr);

		// payload
		String payload = "{ \"sub\": \"1234567\" , \"name\": \"李宁\" }";
		String payloadB64 = Base64.encode(payload);

		// Signature
		String s = SecureUtil.md5(headerB64 + "." + payloadB64);
		String signature = Base64.encode(s);
		String jwt =  headerB64+"."+payloadB64+"."+signature;

		System.out.println(jwt);
	}
}
