package com.raise.ums.manager.query;

import com.raise.core.query.Query;

public class AccessQuery extends Query {

	public AccessQuery withNameEqual(String name) {
		getFirstCriteria().andEqual(RoleProperty.name, name);
		return this;
	}

	public AccessQuery withNameLike(String name) {
		getFirstCriteria().andLike(RoleProperty.name, name);
		return this;
	}

	public AccessQuery withPidEqual(String pid) {
		getFirstCriteria().andEqual(RoleProperty.pid, pid);
		return this;
	}

}
