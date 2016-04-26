package com.raise.ums.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.ums.dao.NodeDao;
import com.raise.ums.entity.NodeEntity;
import com.raise.ums.manager.query.NodeQuery;


@Component
public class NodeManager extends GenericeManager<NodeEntity, NodeDao>{
	@Autowired
	private NodeDao dao;
	
	@Override
	protected NodeDao getDao() {
		return this.dao;
	}
	


	public NodeEntity findByName(String name) {
		NodeQuery query = new NodeQuery();
		query.withNameEqual(name);
		return this.single(query);
	}

}
