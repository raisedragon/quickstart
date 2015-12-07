package com.raise.core.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.raise.core.mybatis.Page;

public class Query implements Serializable{

    /**
     * 条件集列表
     */
    private List<Criteria> criterias = new ArrayList<Criteria>();
    /**
     * 分页
     */
    private Page page;

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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
    

}
