package com.raise.spi;

import java.io.Serializable;
import java.util.Date;

public class SPICommand implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String serialMumber;
	protected Date timestamp;
	protected String sourceSystem;
	protected String targetSystem;
	protected String userId;
	protected String groupId;
	
	public String getSerialMumber() {
		return serialMumber;
	}
	public void setSerialMumber(String serialMumber) {
		this.serialMumber = serialMumber;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getTargetSystem() {
		return targetSystem;
	}
	public void setTargetSystem(String targetSystem) {
		this.targetSystem = targetSystem;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	

}
