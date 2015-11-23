package com.raise.core.manager;

import java.util.Date;
import java.util.List;

import com.raise.core.dao.BaseDao;
import com.raise.core.entity.BaseEntity;
import com.raise.core.mybatis.Page;
import com.raise.core.mybatis.PaginationInterceptor;
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

	/**
	 * 根据查询对象进行查询
	 * @param query 查询参数对象
	 * @return
	 */
	public List<E> list(Query query) {
		return getDao().getByCriteria(query);
	}

	/**
	 * 根据查询与分页对象进行分页查询
	 * @param query 查询参数对象
	 * @param page 分页对象
	 * @return
	 */
	public List<E> list(Query query,Page page){
		PaginationInterceptor.startPage(page);
		List<E> list = this.list(query); 
		return list;
	}
	
	/**
	 * 根据查询对象进行查询。最多查询到一条记录，如果多于一条记录，则抛出异常
	 * @param query
	 * @return
	 */
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

	/**
	 * 计算总数
	 * @param query
	 * @return
	 */
	public long count(Query query) {
		return getDao().countByCriteria(query);
	}
	
	
	
}
