package com.raise.core.query;

/**
 * 条件操作符
 * 
 * @author longsheng.wang
 */
public enum CriteriaOperator {
    /**
     * name = value
     */
    Equal,
    /**
     * name <= value
     */
    LessThanOrEqual,
    /**
     * name >= value
     */
    GreaterThanOrEqual,
    /**
     * name != value
     */
    NotEqual,
    /**
     * name is null
     */
    IsNull,
    /**
     * name is not null
     */
    IsNotNull,
    /**
     * name like '%'+value+'%'
     */
    Like,
    /**
     * name like '%'+value
     */
    FirstLike,
    /**
     * name like value+'%'
     */
    LastLike,
    /**
     * name like '%'+value+'%'
     */
    NotLike,
    /**
     * name not like '%'+value
     */
    NotFirstLike,
    /**
     * name not like value+'%'
     */
    NotLastLike,
    /**
     * name in (value1,value2,...)
     */
    In,
    /**
     * name not in (value1,value2,...)
     */
    NotIn,
    /**
     * name between value1 and value2
     */
    Between,
    /**
     * name not between value1 and value2
     */
    NotBetween;

    public String value() {
        return name();
    }

}
