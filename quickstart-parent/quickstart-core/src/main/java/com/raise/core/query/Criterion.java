package com.raise.core.query;


public class Criterion {

    private String           propertyName;    // 实体属性
    private CriteriaOperator criteriaOperator; // 何种比较方式
    private Object           value;           // 进行比较的值


    public Criterion(String propertyName, CriteriaOperator criteriaOperator, Object value){
        this.propertyName = propertyName;
        this.value = value;
        this.criteriaOperator = criteriaOperator;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public CriteriaOperator getCriteriaOperator() {
        return criteriaOperator;
    }

    public void setCriteriaOperator(CriteriaOperator criteriaOperator) {
        this.criteriaOperator = criteriaOperator;
    }
}
