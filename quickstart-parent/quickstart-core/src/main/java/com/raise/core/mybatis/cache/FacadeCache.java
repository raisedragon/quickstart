package com.raise.core.mybatis.cache;


import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.mybatis.caches.ehcache.EhcacheCache;
import org.mybatis.caches.ehcache.LoggingEhcache;
import org.mybatis.caches.redis.RedisCache;

/**
 * 封装基它的cache实现，根据系统属性，使用不同的cache
 * @author raise
 *
 */
public class FacadeCache implements Cache {

	private static final String CACHE_TYPE = "mybatis.cache.type";
	
	private Cache cache;
	
	public FacadeCache(final String id) {
		String type = System.getProperty(CACHE_TYPE);
		if("Redis".equalsIgnoreCase(type)){
			cache = new RedisCache(id);
		}else if("LoggingEhcache".equalsIgnoreCase(type)){
			cache = new LoggingEhcache(id);
		}else if("Ehcache".equalsIgnoreCase(type)){
			cache = new EhcacheCache(id);
		}else{
			cache = new EhcacheCache(id);
		}
	}

	@Override
	public String getId() {
		return cache.getId();
	}

	@Override
	public int getSize() {
		return cache.getSize();
	}

	@Override
	public void putObject(Object key, Object value) {
		cache.putObject(key, value);
		
	}

	@Override
	public Object getObject(Object key) {
		return cache.getObject(key);
	}

	@Override
	public Object removeObject(Object key) {
		return cache.removeObject(key);
	}

	@Override
	public void clear() {
		cache.clear();
		
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return cache.getReadWriteLock();
	}

}
