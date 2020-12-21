package cn.catguild.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author liu.zhi
 * @date 2020/12/21 10:20
 */
public class DateUtil {

	/**
	 * 时间戳格式化
	 *
	 *
	 * @param epochMilli 时间戳
	 * @return 默认时区转换，默认输出格式
	 */
	public static String timestampToString(long epochMilli) {
		Locale lo = Locale.getDefault();
		String zoneId = ZoneId.systemDefault().getId();
		Instant ins = Instant.ofEpochMilli(epochMilli);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
	}

	/**
	 * 时间戳格式化
	 *
	 * @param epochMilli 时间戳
	 * @param lo 时间格式化格式
	 * @param zoneId 时区
	 * @return 指定时区
	 */
	public static String timestampToString(long epochMilli, Locale lo, String zoneId) {
		Instant ins = Instant.ofEpochMilli(epochMilli);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
	}



}
