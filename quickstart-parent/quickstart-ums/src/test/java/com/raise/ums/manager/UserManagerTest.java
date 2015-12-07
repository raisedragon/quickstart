package com.raise.ums.manager;

import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;

import com.raise.ums.entity.UserEntity;
import com.raise.ums.test.BaseTest;


public class UserManagerTest extends BaseTest{
	
	@Autowired
	protected UserManager userManager;
	
//	@Test
//	@Repeat(100)
	public void testAdd(){
		UserEntity entity = new UserEntity();
		entity.setId(idGenerator.nextStrId());
		entity.setAccount(entity.getId());
		entity.setPassword("888");
		entity.setName(entity.getId());
		entity.setEmail(entity.getId()+"@mail.com");
		userManager.add(entity);
	}
	
	@Test
	public void testGet(){
		userManager.get("667253642511777792");
		userManager.get("667253642511777792");
		System.out.println(11111111);
	}
	
	@Test
	public void testGet2(){
		userManager.get("667253642511777792");
		userManager.get("667253642511777792");
		System.out.println(11111111);
	}

}
