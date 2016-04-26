package com.raise.ums.entity;

import com.raise.core.entity.BaseEntity;

/**
 * 节点
 * 
 * @version 1.0
 * @author
 */
public class NodeEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 836687017816561225L;
	// 名称
	private String name;
	// 标题
	private String title;
	// 备注
	private String remark;
	// 排序
	private String sort;
	// 父节点ID
	private String pid;
	// 级别
	private Integer level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
