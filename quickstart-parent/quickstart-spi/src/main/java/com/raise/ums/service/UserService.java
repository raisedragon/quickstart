package com.raise.ums.service;

import java.util.List;

import com.raise.spi.StringCommand;
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
	List<UserEntity> queryUser(QueryUserCommand cmd);

	/**
	 * 根据邮件查找用户
	 * @param cmd
	 * @return
	 */
	UserEntity findByEmail(StringCommand cmd);

	/**
	 * 添加用戶
	 * @param cmd
	 */
	void save(SaveUserCommand cmd);

	UserEntity findByName(StringCommand cmd);
}
