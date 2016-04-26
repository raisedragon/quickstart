package com.raise.ums.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.ums.dao.RoleDao;
import com.raise.ums.entity.RoleEntity;
import com.raise.ums.manager.query.RoleQuery;


@Component
public class RoleManager extends GenericeManager<RoleEntity, RoleDao>{
	@Autowired
	private RoleDao dao;
	
	@Override
	protected RoleDao getDao() {
		return this.dao;
	}

	public RoleEntity findByName(String name) {
		RoleQuery query = new RoleQuery();
		query.withNameEqual(name);
		return this.single(query);
	}

}
