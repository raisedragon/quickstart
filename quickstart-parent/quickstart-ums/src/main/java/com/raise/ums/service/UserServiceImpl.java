package com.raise.ums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raise.spi.StringCommand;
import com.raise.spi.exception.SPIException;
import com.raise.ums.cmd.SaveUserCommand;
import com.raise.ums.cmd.QueryUserCommand;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.manager.UserManager;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserManager userManager;

	@Override
	public List<UserEntity> queryUser(QueryUserCommand cmd) throws SPIException {
		try {
			return userManager.list(cmd.getUserQuery());
		} catch (SPIException e) {
			throw e;
		} catch (Exception e) {
			throw new SPIException(e);
		}
	}

	@Override
	public UserEntity findByEmail(StringCommand cmd) throws SPIException {
		try {
			return userManager.findByEmail(cmd.getKey());
		} catch (SPIException e) {
			throw e;
		} catch (Exception e) {
			throw new SPIException(e);
		}
	}

	@Override
	public void save(SaveUserCommand cmd) throws SPIException {
		try {
			UserEntity userEntity = cmd.getUser();
			if (userEntity.getId() == null) {
				userManager.add(userEntity);
			} else {
				userManager.update(userEntity);
			}
		} catch (SPIException e) {
			throw e;
		} catch (Exception e) {
			throw new SPIException(e);
		}
	}

	@Override
	public UserEntity findByName(StringCommand cmd) throws SPIException {
		try {
			return userManager.findByName(cmd.getKey());
		} catch (SPIException e) {
			throw e;
		} catch (Exception e) {
			throw new SPIException(e);
		}
	}

	@Override
	public UserEntity findByAccount(StringCommand cmd) throws SPIException {
		try {
			return userManager.findByAccount(cmd.getKey());
		} catch (SPIException e) {
			throw e;
		} catch (Exception e) {
			throw new SPIException(e);
		}
	}

}
