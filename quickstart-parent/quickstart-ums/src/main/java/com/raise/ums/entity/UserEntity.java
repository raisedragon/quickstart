package com.raise.ums.entity;

import java.io.Serializable;
import java.util.Date;

import com.raise.core.entity.BaseEntity;

/**
 * 用户信息
 * 
 * @version 1.0
 * @author
 */
public class UserEntity   extends BaseEntity {
	// 姓名
	private String name;
	// 邮件
	private String email;
	// 密码
	private String password;
	// 账号
	private String account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
