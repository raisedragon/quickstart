package com.raise.ums.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.raise.core.entity.BaseEntity;

public class UserEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = UserEntity.NOT_BLANK_MESSAGE)
	protected String name;
	protected String account;
    @NotBlank(message = UserEntity.NOT_BLANK_MESSAGE)
	@Email(message = UserEntity.EMAIL_MESSAGE)
	protected String email;
    @NotBlank(message = UserEntity.NOT_BLANK_MESSAGE)
	protected String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	
	
	
	

}
