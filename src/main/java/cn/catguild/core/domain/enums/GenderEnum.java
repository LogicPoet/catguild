package cn.catguild.core.domain.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 性别枚举
 *
 * @author zhi.liu
 * @date 2021-07-02 17:34
 */
public enum  GenderEnum implements IEnum<Integer> {

	/** 男性 **/
	MAN(1, "男性"),
	/** 女性 **/
	FEMALE(2, "女性"),
	/** 隐藏性别 **/
	HIDE(3, "隐藏性别");

	/**
	 * 标记响应json值
	 */
	@JsonValue
	private final int code;

	private final String desc;

	GenderEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * 设置数据库自动填充
	 *
	 * @return 填入数据库的值
	 */
	@Override
	public Integer getValue() {
		return this.code;
	}

	/**
	 * 获取code对应的描述
	 *
	 * @return code对应的描述
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * 获取code
	 *
	 * @return code值
	 */
	public Integer getCode() {
		return this.code;
	}

}
