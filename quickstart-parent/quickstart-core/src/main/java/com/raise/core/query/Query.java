package com.raise.core.query;

import java.util.ArrayList;
import java.util.List;

public class Query {

    /**
     * 条件集列表
     */
    private List<Criteria> criterias = new ArrayList<Criteria>();

    protected Criteria getFirstCriteria() {
        if (criterias.isEmpty()) {
            criterias.add(new Criteria());
        }
        return criterias.get(0);
    }

    /**
     * 创建以Or为粒度的条件集
     * 
     * @return
     */
    public Criteria or() {
        Criteria criteria = new Criteria();
        criterias.add(criteria);
        return criteria;
    }

    /**
     * 条件是否为空
     * 
     * @return
     */
    public boolean isCriteriaEmpty() {
        for (Criteria criteria : criterias) {
            if (!criteria.getCriterions().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public List<Criteria> getCriterias() {
        return criterias;
    }

}
