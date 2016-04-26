package com.raise.ums.manager.query;

import com.raise.core.query.Query;

public class RoleUserQuery extends Query {

	public RoleUserQuery withRoleIdEqual(String roleId) {
		getFirstCriteria().andEqual(RoleUserProperty.roleId, roleId);
		return this;
	}

	public RoleUserQuery withUserIdEqual(String userId) {
		getFirstCriteria().andEqual(RoleUserProperty.userId, userId);
		return this;
	}
}
