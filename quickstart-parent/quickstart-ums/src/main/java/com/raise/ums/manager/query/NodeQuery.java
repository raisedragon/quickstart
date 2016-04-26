package com.raise.ums.manager.query;

import com.raise.core.query.Query;

public class NodeQuery extends Query {

	public NodeQuery withNameEqual(String name) {
		getFirstCriteria().andEqual(NodeProperty.name, name);
		return this;
	}

	public NodeQuery withNameLike(String name) {
		getFirstCriteria().andLike(NodeProperty.name, name);
		return this;
	}

	public NodeQuery withPidEqual(String pid) {
		getFirstCriteria().andEqual(NodeProperty.pid, pid);
		return this;
	}
	
	public NodeQuery withLevelEqual(Integer level) {
		getFirstCriteria().andEqual(NodeProperty.level, level);
		return this;
	}

}
