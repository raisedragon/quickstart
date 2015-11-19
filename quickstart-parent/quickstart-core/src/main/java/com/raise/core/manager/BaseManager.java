package com.raise.core.manager;

import java.util.Date;
import java.util.List;

import com.raise.core.dao.BaseDao;
import com.raise.core.entity.BaseEntity;
import com.raise.core.query.Query;

/**
 * Manager 基础类
 * 
 * @author longsheng.wang
 *
 * @param <E>
 * @param <D>
 */
public abstract class BaseManager<E extends BaseEntity, D extends BaseDao<E>> {
	
	/**
	 * 获取对应的DAO实现
	 * 
	 * @return
	 */
	protected abstract D getDao();

	/**
	 * 根据ID，查询对象
	 * 
	 * @param id
	 * @return
	 */
	public E get(String id) {
		return getDao().get(id);
	}

	/**
	 * 保存对象到数据库
	 * 
	 * @param entity
	 */
	public void add(E entity) {
		getDao().add(entity);
	}

	/**
	 * 根据ID，从数据库中删除对象
	 * 
	 * @param id
	 */
	public void delete(String id) {
		getDao().delete(id);
	}

	/**
	 * 更新对象到数据库
	 * 
	 * @param entity
	 * @return
	 */
	public int update(E entity) {
		Date date = new Date();
		entity.setUpdated(date);
		return getDao().update(entity);
	}

	/**
	 * 设置记录状态“失活”
	 * 
	 * @param id
	 */
	public void disable(String id) {
		getDao().disable(id);
	}

	/**
	 * 设置记录状态“激活”
	 * 
	 * @param id
	 */
	public void enable(String id) {
		getDao().enable(id);
	}

	public List<E> list(Query query) {
		return getDao().getByCriteria(query);
	}

	public E single(Query query) {
		List<E> list = getDao().getByCriteria(query);
		if (list.size() > 1) {
			throw new RuntimeException("too many result!");
		} else if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public long count(Query query) {
		return getDao().countByCriteria(query);
	}
}
