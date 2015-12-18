package com.raise.ums.service;

import java.util.List;

import com.raise.spi.StringCommand;
import com.raise.spi.exception.SPIException;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.cmd.SaveUserCommand;
import com.raise.ums.cmd.QueryUserCommand;

/**
 * 
 * 用户服务接口
 * @author raise
 *
 */
public interface UserService {
	
	/**
	 * 查询用户
	 * @param cmd
	 * @return
	 */
	List<UserEntity> queryUser(QueryUserCommand cmd) throws SPIException;

	/**
	 * 根据邮件查找用户
	 * @param cmd
	 * @return
	 */
	UserEntity findByEmail(StringCommand cmd) throws SPIException;

	/**
	 * 添加用戶
	 * @param cmd
	 */
	void save(SaveUserCommand cmd) throws SPIException;

	UserEntity findByName(StringCommand cmd) throws SPIException;
	
	
	UserEntity findByAccount(StringCommand cmd) throws SPIException;
}
