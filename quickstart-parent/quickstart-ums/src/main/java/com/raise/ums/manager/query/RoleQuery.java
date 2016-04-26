package com.raise.ums.manager.query;

import com.raise.core.query.Query;

public class RoleQuery extends Query {

	public RoleQuery withNameEqual(String name) {
		getFirstCriteria().andEqual(RoleProperty.name, name);
		return this;
	}

	public RoleQuery withNameLike(String name) {
		getFirstCriteria().andLike(RoleProperty.name, name);
		return this;
	}

	public RoleQuery withPidEqual(String pid) {
		getFirstCriteria().andEqual(RoleProperty.pid, pid);
		return this;
	}

}
