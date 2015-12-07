package com.raise.ums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raise.spi.StringCommand;
import com.raise.ums.cmd.QueryUserCommand;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.manager.UserManager;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserManager userManager;
	@Override
	public List<UserEntity> queryUser(QueryUserCommand cmd) {
		return userManager.list(cmd.getUserQuery());
	}

	@Override
	public UserEntity findByEmail(StringCommand cmd) {
		return userManager.findByEmail(cmd.getKey());
	}

}
