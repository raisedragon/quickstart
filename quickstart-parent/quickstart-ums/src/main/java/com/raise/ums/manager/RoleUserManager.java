package com.raise.ums.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.ums.dao.RoleUserDao;
import com.raise.ums.entity.RoleUserEntity;


@Component
public class RoleUserManager extends GenericeManager<RoleUserEntity, RoleUserDao>{
	@Autowired
	private RoleUserDao dao;
	
	@Override
	protected RoleUserDao getDao() {
		return this.dao;
	}

}
