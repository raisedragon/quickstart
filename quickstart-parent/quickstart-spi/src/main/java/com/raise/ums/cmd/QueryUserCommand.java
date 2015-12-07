package com.raise.ums.cmd;

import com.raise.spi.SPICommand;
import com.raise.ums.query.UserQuery;


public class QueryUserCommand extends SPICommand{
	private static final long serialVersionUID = 1L;
	private UserQuery userQuery;
	
	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}
	
	public UserQuery getUserQuery() {
		return userQuery;
	}
}
