package com.raise.ums.manager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.raise.ums.entity.UserEntity;
import com.raise.ums.test.UMSBaseTest;


public class UserManagerTest extends UMSBaseTest{
	
	@Autowired
	protected UserManager userManager;
	
//	@Test
	public void testAdd(){
		UserEntity entity = new UserEntity();
		entity.setId(idGenerator.nextStrId());
		entity.setAccount(entity.getId());
		entity.setPassword("888");
		entity.setName(entity.getId());
		entity.setEmail(entity.getId()+"@mail.com");
		entity.setActive(false);
		entity.setDeleted(true);
		userManager.add(entity);
		
	}
	
//	@Test
	public void testGet(){
		userManager.get("667253642511777792");
		userManager.get("667253642511777792");
		System.out.println(11111111);
	}
	
	@Test
	public void testFindByAccount(){
		userManager.findByAccount("667253642511777792");
	}
	
	

}
