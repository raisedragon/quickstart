package com.raise.core.dao;

import java.util.List;

import com.raise.core.entity.BaseEntity;
import com.raise.core.query.Query;

/**
 * 基础DAO
 * @author longsheng.wang
 *
 * @param <E>
 */
public interface BaseDao<E extends BaseEntity> {
	/**
	 * 根据ID，查询对象
	 * @param id
	 * @return
	 */
	E get(String id);

	/**
	 * 保存对象到数据库
	 * @param entity
	 */
	void add(E entity);

	/**
	 * 根据ID，从数据库中删除对象
	 * @param id
	 */
	void delete(String id);

	/**
	 * 更新对象到数据库
	 * @param entity
	 * @return
	 */
	int update(E entity);
	
	/**
	 * 设置记录状态“失活”
	 * @param id
	 */
	void disable(String id);
	
	/**
	 * 设置记录状态“激活”
	 * @param id
	 */
	void enable(String id);

    List<E> getByCriteria(Query query);

    long countByCriteria(Query query);
}
