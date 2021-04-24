package cn.catguild.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

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

	private static final SignatureAlgorithm SIG_ALG = SignatureAlgorithm.HS256;

	//两个黄鹂鸣翠柳，
	//一行白鹭上青天。
	//窗含西岭千秋雪，
	//门泊东吴万里船。
	private static final String SIGN_KEY = "lghlmcl-yhblsqt-chxlqqx-mbdwwlc-asdjoasjdojsapojd";

	private static final String BASE64_SECURITY = Base64.encodeBase64String(SIGN_KEY.getBytes(StandardCharsets.UTF_8));

	private static final String BEARER = "bearer";

	public static final Integer AUTH_LENGTH = 7;

	private JwtUtil() {
	}

	/**
	 * 创建令牌
	 *
	 * @param user      user 用户信息
	 * @param issuer    issuer 令牌签发方
	 * @param audience  audience 令牌接受方
	 * @return jwt
	 */
	public static String createJWT(Map<String, String> user, String issuer, String audience) {
		//生成签名密钥
		byte[] apiKeySecretBytes = Base64.encodeBase64(BASE64_SECURITY.getBytes(StandardCharsets.UTF_8));
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, SIG_ALG.getJcaName());

		//添加构成JWT的类
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
			.setIssuer(issuer)
			.setAudience(audience)
			.signWith(signingKey, SIG_ALG);

		//设置JWT参数
		user.forEach(builder::claim);

		//添加Token过期时间 24 * 3600 = 86400
		LocalDateTime now = LocalDateTime.now();
		long nowMilli = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
		long expMilli = now.plusDays(1).toInstant(ZoneOffset.of("+8")).toEpochMilli();
		builder.setExpiration(new Date(expMilli)).setNotBefore(new Date(nowMilli));

		return builder.compact();
	}

	/**
	 * 获取token串
	 *
	 * @param auth token
	 * @return String
	 */
	public static String getToken(String auth) {
		if ((auth != null) && (auth.length() > AUTH_LENGTH)) {
			String headStr = auth.substring(0, 6).toLowerCase();
			if (headStr.compareTo(BEARER) == 0) {
				auth = auth.substring(7);
				return auth;
			}
		}
		return null;
	}

	/**
	 * 解析jsonWebToken
	 *
	 * @param jsonWebToken token串
	 * @return Claims
	 */
	public static Claims parseJWT(String jsonWebToken) {
		try {
			return Jwts.parserBuilder()
				.setSigningKey(Base64.encodeBase64(BASE64_SECURITY.getBytes(StandardCharsets.UTF_8)))
				.build()
				.parseClaimsJws(jsonWebToken).getBody();
		} catch (Exception ex) {
			return null;
		}
	}
}
