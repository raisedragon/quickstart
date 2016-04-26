package com.raise.ums.entity;

import java.io.Serializable;
import java.util.Date;

import com.raise.core.entity.BaseEntity;

/**
 * 角色
 * @version 1.0
 * @author
 */
public class RoleEntity   extends BaseEntity {
	// 角色名
	private String name;
	// 父角色ID
	private String pid;
	// 备注
	private String remark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
