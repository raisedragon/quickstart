package com.raise.ums.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.ums.dao.UserDao;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.query.UserQuery;


@Component
public class UserManager extends GenericeManager<UserEntity, UserDao>{
	@Autowired
	private UserDao dao;
	
	@Override
	protected UserDao getDao() {
		return this.dao;
	}
	
	
	public UserEntity findByEmail(String email){
		UserQuery query = new UserQuery();
		query.withEmailEqual(email);
		return this.single(query);
	}
	
	public UserEntity findByAccount(String account){
		UserQuery query = new UserQuery();
		query.withAccountEqual(account);
		return this.single(query);
	}

}
