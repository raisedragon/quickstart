package com.raise.ums.entity;

import com.raise.core.entity.BaseEntity;

/**
 * 访问控制
 * @version 1.0
 * @author
 */
public class AccessEntity  extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 组ID
	private String groupId;
	// 角色ID
	private String roleId;
	// 节点ID
	private String nodeId;
	// 级别
	private Integer level;
	// 模块名
	private String module;
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
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
}
