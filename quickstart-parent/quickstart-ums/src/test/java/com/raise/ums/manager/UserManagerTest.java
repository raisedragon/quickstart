package com.raise.ums.manager;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.raise.core.mybatis.Page;
import com.raise.ums.entity.UserEntity;
import com.raise.ums.manager.query.UserQuery;
import com.raise.ums.test.UMSBaseTest;


public class UserManagerTest extends UMSBaseTest{
	
	@Autowired
	protected UserManager manager;
	
	@Test
	public void testAdd(){
		UserEntity entity = new UserEntity();
		entity.setId(idGenerator.nextStrId());
		entity.setAccount(entity.getId());
		entity.setPassword("888");
		entity.setName(entity.getId());
		entity.setEmail(entity.getId()+"@mail.com");
		entity.setActive(true);
		entity.setDeleted(false);
		manager.add(entity);
		
	}
	
	@Test
	public void testGet(){
		UserEntity entity = manager.get("724428875295096832");
		System.out.println(entity);
	}
	
	@Test
	public void testFindByAccount(){
		UserEntity entity = manager.findByAccount("724428875295096832");
		System.out.println(entity);
	}

	@Test
	public void testList(){
		UserQuery query = new UserQuery();
		Page page = new Page(1,100);
		query.setPage(page);
		List<UserEntity> list = manager.list(query);
		for(UserEntity entity:list){
			System.out.println(entity);
		}
	}
	
}
