package cn.catguild.domain.entity;

import cn.catguild.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 职员实体
 *
 * @author liu.zhi
 * @date 2020/12/11 16:11
 */
//@Data
//@EqualsAndHashCode(callSuper = false)
public class Staff extends BaseEntity {

	// 用户id
	private Integer staffId;

	// 用户名
	private String Name;

	// 性别
	private Short sex;

	// 年龄
	private Short age;

	// 身份id
	private String idCard;

	// 部门id
	private Integer deptId;

	// 入职时间
	private Long entryTime;

	// 离职时间
	private Long resignationTime;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Long getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Long entryTime) {
		this.entryTime = entryTime;
	}

	public Long getResignationTime() {
		return resignationTime;
	}

	public void setResignationTime(Long resignationTime) {
		this.resignationTime = resignationTime;
	}
}
