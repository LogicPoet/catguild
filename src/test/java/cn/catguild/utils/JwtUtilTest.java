package cn.catguild.utils;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtilTest {

	@Test
	public void createJWT() {
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("username","李月");
		userInfo.put("sex","男");
		String jwt = JwtUtil.createJWT(userInfo, "issuer", "audience");
		log.debug("jwt令牌：{}",jwt);
	}

	@Test
	public void getToken() {
		String jwt = "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJhdWQiOiJhdWRpZW5jZSIsInNleCI6IueUtyIsInVzZXJuYW1lIjoi5p2O5pyIIiwiZXhwIjoxNjA4NTE0NTQ1LCJuYmYiOjE2MDg1MTQ0NTl9.xXf301gUdQ0BygpWuGUpvvP84YCY4lRrKNbfThbWXoE";
		String token = JwtUtil.getToken(jwt);
		log.debug("token：{}",token);
	}

	@Test
	public void parseJWT() {
		String jwt = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJhdWQiOiJhdWRpZW5jZSIsInNleCI6IueUtyIsInVzZXJuYW1lIjoi5p2O5pyIIiwiZXhwIjoxNjA4NjA0MjkzLCJuYmYiOjE2MDg1MTc4OTN9.Nre8rohfIk6qmrLQrxRo3hkZ2NKsKefkxKs8vIKNuyI";
		String token = JwtUtil.getToken(jwt);
		Claims claims = JwtUtil.parseJWT(token);

		String jwt2 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJhdWQiOiJhdWRpZW5jZSIsIm5hbWUiOiLnmb3otbciLCJleHAiOjE2MDg2MjUxMTksIm5iZiI6MTYwODUzODcxOX0.kS120L10-NIDJZIJKtIYzrSMF103NuMlYzMhwf0uUIg";
		Claims claims2 = JwtUtil.parseJWT(jwt2);
		log.debug("jwt令牌claims：{}",claims);
		log.debug("jwt2令牌claims：{}",claims2);
	}

	@Test
	public void test() {
		//1608517893848
		//1608517893000
		long exp = 1608604157000l;
		long nbf = 1608517757000l;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date(exp);
		Date date1 = new Date(nbf);
		log.debug("exp时间：{}",df.format(date));
		log.debug("nbf时间：{}",df.format(date1));
	}
}
