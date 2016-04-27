package com.raise.web.ums.xservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raise.core.mybatis.Page;
import com.raise.spi.StringCommand;
import com.raise.ums.cmd.SaveUserCommand;
import com.raise.ums.cmd.QueryUserCommand;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.query.UserQuery;
import com.raise.ums.service.UserService;

@Service
public class UserXService {
	
	@Autowired
	private UserService service;

	public UserEntity findByEmail(String username) {
		StringCommand cmd = new StringCommand();
		cmd.setKey(username);
		return service.findByEmail(cmd);
	}
	
	public UserEntity findByAccount(String account) {
		StringCommand cmd = new StringCommand();
		cmd.setKey(account);
		return service.findByAccount(cmd);
	}
	
	
	public List<UserEntity> list(UserQuery query){
		QueryUserCommand cmd = new QueryUserCommand();
		cmd.setUserQuery(query);
		return service.queryUser(cmd);
	}


	public void add(UserEntity user) {
		SaveUserCommand cmd = new SaveUserCommand();
		cmd.setUser(user);
		service.save(cmd);
	}
	
}
