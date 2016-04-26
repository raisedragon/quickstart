package com.raise.core.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public abstract class BaseEntity implements Serializable {

	protected String id;
	
    // 创建人
    protected String  createdBy;
    // 更新人
    protected String  updatedBy;
    // 创建时间
    protected Date    created;
    // 更新时间
    protected Date    updated;
    // 创建人组织ID
    protected String  groupId;

    protected boolean isActive = true;

    protected boolean isDeleted = false;

    public String getId() {
		return id;
	}
    
    public void setId(String id) {
		this.id = id;
	}

    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDelete) {
        this.isDeleted = isDelete;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
