package com.raise.ums.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.ums.dao.AccessDao;
import com.raise.ums.entity.AccessEntity;
import com.raise.ums.manager.query.AccessQuery;


@Component
public class AccessManager extends GenericeManager<AccessEntity, AccessDao>{
	@Autowired
	private AccessDao dao;
	
	@Override
	protected AccessDao getDao() {
		return this.dao;
	}


	public AccessEntity findByName(String name) {
		AccessQuery query = new AccessQuery();
		query.withNameEqual(name);
		return this.single(query);
	}

}
