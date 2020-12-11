package cn.catguild.domain.base;

import lombok.Data;

/**
 * 基础实体类
 *
 * @author liu.zhi
 * @date 2020/12/11 17:41
 */
//@Data
public class BaseEntity {

	// 创建时间戳
	private Long crateTime;

	// 更新时间戳
	private Long updateTime;

	// 创建人
	private Integer crateStaff;

	// 修改人
	private Integer updateStaff;

	public Long getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Long crateTime) {
		this.crateTime = crateTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCrateStaff() {
		return crateStaff;
	}

	public void setCrateStaff(Integer crateStaff) {
		this.crateStaff = crateStaff;
	}

	public Integer getUpdateStaff() {
		return updateStaff;
	}

	public void setUpdateStaff(Integer updateStaff) {
		this.updateStaff = updateStaff;
	}
}
