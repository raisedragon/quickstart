package com.raise.core.ctx;

import java.util.Date;

public class Context {
	static ThreadLocal<String> userIdLocal = new ThreadLocal<String>();
	static ThreadLocal<String> organizationIdLocal = new ThreadLocal<String>();

	public static String currentUserId() {
		return userIdLocal.get();
	}

	public static void setUserId(String userId) {
		userIdLocal.set(userId);
	}

	public static void removeUserId() {
		userIdLocal.remove();
	}

	public static String currentOrganizationId() {
		return organizationIdLocal.get();
	}

	public static void setOrganizationIdLocal(String organizationId) {
		organizationIdLocal.set(organizationId);
	}

	public static void removeOrganizationId() {
		organizationIdLocal.remove();
	}

	public static Date currentDate() {
		return new Date();
	}
}
