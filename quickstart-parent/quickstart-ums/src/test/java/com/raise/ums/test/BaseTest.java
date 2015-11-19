package com.raise.ums.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.raise.core.identity.IdGenerator;

@ContextConfiguration({ "classpath:conf/spring/spring-context.xml" })
@ActiveProfiles({ "test" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class BaseTest {

    protected Logger         logger = LoggerFactory.getLogger(this.getClass());
    

    @Autowired
    protected IdGenerator idGenerator;
    
    @Test
    public void test(){
    	Assert.assertNotNull(idGenerator);
    }
}
