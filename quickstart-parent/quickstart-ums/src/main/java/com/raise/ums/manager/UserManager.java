package com.raise.ums.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.core.exception.FieldValidateException;
import com.raise.core.exception.ValidateException;
import com.raise.ums.dao.UserDao;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.query.UserProperty;
import com.raise.ums.query.UserQuery;


@Component
public class UserManager extends GenericeManager<UserEntity, UserDao>{
	@Autowired
	private UserDao dao;
	
	@Override
	protected UserDao getDao() {
		return this.dao;
	}
	
	@Override
	public void add(UserEntity entity) {
		validEmail(entity.getEmail());
		super.add(entity);
	}
	
	private void validEmail(String email){
		UserEntity user = this.findByEmail(email);
		if(user!=null){
			FieldValidateException e =new FieldValidateException("Email address has used");
			e.setField(UserProperty.email);
			throw e;
		}
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


	public UserEntity findByName(String name) {
		UserQuery query = new UserQuery();
		query.withNameEqual(name);
		return this.single(query);
	}

}
