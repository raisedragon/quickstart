package com.raise.ums.cmd;

import com.raise.spi.SPICommand;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.query.UserQuery;


public class SaveUserCommand extends SPICommand{
	private static final long serialVersionUID = 1L;
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
