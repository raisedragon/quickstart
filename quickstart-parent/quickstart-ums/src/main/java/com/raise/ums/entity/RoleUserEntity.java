package com.raise.ums.entity;

import java.io.Serializable;
import java.util.Date;

import com.raise.core.entity.BaseEntity;

/**
 * 用户角色关系
 * 
 * @version 1.0
 * @author
 */
public class RoleUserEntity extends BaseEntity {
	// 角色ID
	private String roleId;
	// 用户ID
	private String userId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
