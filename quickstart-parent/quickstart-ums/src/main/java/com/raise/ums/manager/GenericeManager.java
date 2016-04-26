package com.raise.ums.manager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.raise.core.dao.BaseDao;
import com.raise.core.entity.BaseEntity;
import com.raise.core.identity.IdGenerator;
import com.raise.core.manager.BaseManager;

public abstract class GenericeManager<E extends BaseEntity, D extends BaseDao<E>> extends BaseManager<E, D> {

	@Autowired
	protected IdGenerator idGenerator;

	@Override
	public void add(E entity) {
		if (StringUtils.isBlank(entity.getId())) {
			entity.setId(idGenerator.nextStrId());
		}
		super.add(entity);
	}
}
