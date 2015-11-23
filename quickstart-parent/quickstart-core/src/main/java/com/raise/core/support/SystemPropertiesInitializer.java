package com.raise.core.support;

import java.util.Properties;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;

/**
 * 系统属性配置
 * @author raise
 *
 */
public class SystemPropertiesInitializer implements InitializingBean {
	protected Properties properties;
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(properties==null){
			throw new BeanInitializationException("Property [properties] is required");
		}
		System.getProperties().putAll(properties);
	}
}
