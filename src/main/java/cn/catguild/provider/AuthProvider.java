package cn.catguild.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zhi
 * @date 2020/12/18 18:12
 */
public class AuthProvider {

	public static String TARGET = "/**";

	public static String REPLACEMENT = "";

	public static String AUTH_KEY = "authorization";

	private static final List<String> defaultSkipUrl = new ArrayList<>();

	static {
		defaultSkipUrl.add("/auth/login");
	}

	/**
	 * 默认无需鉴权的API
	 */
	public static List<String> getDefaultSkipUrl() {
		return defaultSkipUrl;
	}

}
