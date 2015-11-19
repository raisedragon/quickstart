package com.raise.core.query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Criteria {

    public List<Criterion> criterions;

    public List<Criterion> getCriterions() {
        if (criterions == null) {
            criterions = new ArrayList<Criterion>();
        }
        return criterions;
    }

    public void setCriterions(List<Criterion> criterions) {
        this.criterions = criterions;
    }

    public Criteria and(String propertyName, CriteriaOperator criteriaOperator, Object value) {
        validateCriteria(criteriaOperator, value);
        Criterion criterion = new Criterion(propertyName, criteriaOperator, value);
        getCriterions().add(criterion);
        return this;
    }

    public Criteria andEqual(String propertyName, Object value) {
        CriteriaOperator criteriaOperator = CriteriaOperator.Equal;
        return and(propertyName, criteriaOperator, value);
    }

    public Criteria andLike(String propertyName, Object value) {
        CriteriaOperator criteriaOperator = CriteriaOperator.Like;
        return and(propertyName, criteriaOperator, value);
    }

    public Criteria andIn(String propertyName, List<?> value) {
        CriteriaOperator criteriaOperator = CriteriaOperator.In;
        return and(propertyName, criteriaOperator, value);
    }

    public Criteria andBetween(String propertyName, Object value1, Object value2) {
        CriteriaOperator criteriaOperator = CriteriaOperator.Between;
        List<Object> value = new ArrayList<Object>();
        value.add(value1);
        value.add(value2);
        return and(propertyName, criteriaOperator, value);
    }

    private void validateCriteria(CriteriaOperator criteriaOperator, Object value) {
        switch (criteriaOperator) {
            case IsNull:
            case IsNotNull:
                break;
            case Equal:
                if (value == null) {
                    throw new RuntimeException("criteria value with Equal in operator can not be null");
                }
                break;
            case LessThanOrEqual:
                if (value == null) {
                    throw new RuntimeException("criteria value with LessThanOrEqual in operator can not be null");
                }
                break;
            case GreaterThanOrEqual:
                if (value == null) {
                    throw new RuntimeException("criteria value with GreaterThanOrEqual in operator can not be null");
                }
                break;
            case NotEqual:
                if (value == null) {
                    throw new RuntimeException("criteria value with NotEqual in operator can not be null");
                }
                break;
            case Like:
                if (value == null) {
                    throw new RuntimeException("criteria value with Like in operator can not be null");
                }
                break;
            case FirstLike:
                if (value == null) {
                    throw new RuntimeException("criteria value with FirstLike in operator can not be null");
                }
                break;
            case LastLike:
                if (value == null) {
                    throw new RuntimeException("criteria value with LastLike in operator can not be null");
                }
                break;
            case NotLike:
                if (value == null) {
                    throw new RuntimeException("criteria value with NotLike in operator can not be null");
                }
                break;
            case NotFirstLike:
                if (value == null) {
                    throw new RuntimeException("criteria value with NotFirstLike in operator can not be null");
                }
                break;
            case NotLastLike:
                if (value == null) {
                    throw new RuntimeException("criteria value with NotLastLike in operator can not be null");
                }
                break;
            case In:
                if (value == null) {
                    throw new RuntimeException("criteria value with 'In' operator can not be null");
                }
                if (!value.getClass().isArray() && !(value instanceof Collection)) {
                    throw new RuntimeException("criteria value with 'In' operator must be array or collection");
                }
                if (value.getClass().isArray()) {
                    int len = Array.getLength(value);
                    if (len == 0) {
                        throw new RuntimeException("criteria array value length with 'Not In' operator must greater than 0");
                    }
                }
                if (value instanceof Collection) {
                    Collection<?> collection = (Collection<?>) value;
                    int len = collection.size();
                    if (len == 0) {
                        throw new RuntimeException("criteria collection value length with 'Not In' operator must greater than 0");
                    }
                }
                break;
            case NotIn:
                if (value == null) {
                    throw new RuntimeException("criteria value with 'Not In' operator can not be null");
                }
                if (!value.getClass().isArray() && !(value instanceof Collection)) {
                    throw new RuntimeException("criteria value with 'Not In' operator must be array or collection");
                }
                if (value.getClass().isArray()) {
                    int len = Array.getLength(value);
                    if (len == 0) {
                        throw new RuntimeException("criteria array value length with 'Not In' operator must greater than 0");
                    }
                }
                if (value instanceof Collection) {
                    Collection<?> collection = (Collection<?>) value;
                    int len = collection.size();
                    if (len == 0) {
                        throw new RuntimeException("criteria collection value length with 'Not In' operator must greater than 0");
                    }
                }
                break;
            case Between:
                if (value == null) {
                    throw new RuntimeException("criteria value with 'Not In' operator can not be null");
                }
                if (!value.getClass().isArray() && !(value instanceof Collection)) {
                    throw new RuntimeException("criteria value with 'Not In' operator must be array or collection");
                }
                if (value.getClass().isArray()) {
                    int len = Array.getLength(value);
                    if (len == 2) {
                        throw new RuntimeException("criteria array value length with 'Between' operator must equal to 2");
                    }
                }
                if (value instanceof Collection) {
                    Collection<?> collection = (Collection<?>) value;
                    int len = collection.size();
                    if (len == 2) {
                        throw new RuntimeException("criteria collection value length with 'Between' operator must equal to 2");
                    }
                }
                break;
            case NotBetween:
                if (value == null) {
                    throw new RuntimeException("criteria value with 'Not Between' operator can not be null");
                }
                if (!value.getClass().isArray() && !(value instanceof Collection)) {
                    throw new RuntimeException("criteria value with 'Not Between' operator must be array or collection");
                }
                if (value.getClass().isArray()) {
                    int len = Array.getLength(value);
                    if (len == 2) {
                        throw new RuntimeException("criteria array value length with 'Not Between' operator must equal to 2");
                    }
                }
                if (value instanceof Collection) {
                    Collection<?> collection = (Collection<?>) value;
                    int len = collection.size();
                    if (len == 2) {
                        throw new RuntimeException("criteria collection value length with 'Not Between' operator must equal to 2");
                    }
                }
                break;
        }
    }

}
