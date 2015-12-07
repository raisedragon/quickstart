package com.raise.ums.service;

import java.util.List;

import com.raise.spi.StringCommand;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.cmd.QueryUserCommand;

public interface UserService {
	
	List<UserEntity> queryUser(QueryUserCommand cmd);

	UserEntity findByEmail(StringCommand cmd);
}
