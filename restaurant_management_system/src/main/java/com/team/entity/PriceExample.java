package com.team.entity;

import java.util.ArrayList;
import java.util.List;

public class PriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDishesIdIsNull() {
            addCriterion("dishes_id is null");
            return (Criteria) this;
        }

        public Criteria andDishesIdIsNotNull() {
            addCriterion("dishes_id is not null");
            return (Criteria) this;
        }

        public Criteria andDishesIdEqualTo(Integer value) {
            addCriterion("dishes_id =", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdNotEqualTo(Integer value) {
            addCriterion("dishes_id <>", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdGreaterThan(Integer value) {
            addCriterion("dishes_id >", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dishes_id >=", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdLessThan(Integer value) {
            addCriterion("dishes_id <", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdLessThanOrEqualTo(Integer value) {
            addCriterion("dishes_id <=", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdIn(List<Integer> values) {
            addCriterion("dishes_id in", values, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdNotIn(List<Integer> values) {
            addCriterion("dishes_id not in", values, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdBetween(Integer value1, Integer value2) {
            addCriterion("dishes_id between", value1, value2, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dishes_id not between", value1, value2, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesNameIsNull() {
            addCriterion("dishes_name is null");
            return (Criteria) this;
        }

        public Criteria andDishesNameIsNotNull() {
            addCriterion("dishes_name is not null");
            return (Criteria) this;
        }

        public Criteria andDishesNameEqualTo(String value) {
            addCriterion("dishes_name =", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotEqualTo(String value) {
            addCriterion("dishes_name <>", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameGreaterThan(String value) {
            addCriterion("dishes_name >", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameGreaterThanOrEqualTo(String value) {
            addCriterion("dishes_name >=", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameLessThan(String value) {
            addCriterion("dishes_name <", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameLessThanOrEqualTo(String value) {
            addCriterion("dishes_name <=", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameLike(String value) {
            addCriterion("dishes_name like", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotLike(String value) {
            addCriterion("dishes_name not like", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameIn(List<String> values) {
            addCriterion("dishes_name in", values, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotIn(List<String> values) {
            addCriterion("dishes_name not in", values, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameBetween(String value1, String value2) {
            addCriterion("dishes_name between", value1, value2, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotBetween(String value1, String value2) {
            addCriterion("dishes_name not between", value1, value2, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlIsNull() {
            addCriterion("dishes_imageurl is null");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlIsNotNull() {
            addCriterion("dishes_imageurl is not null");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlEqualTo(String value) {
            addCriterion("dishes_imageurl =", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlNotEqualTo(String value) {
            addCriterion("dishes_imageurl <>", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlGreaterThan(String value) {
            addCriterion("dishes_imageurl >", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("dishes_imageurl >=", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlLessThan(String value) {
            addCriterion("dishes_imageurl <", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlLessThanOrEqualTo(String value) {
            addCriterion("dishes_imageurl <=", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlLike(String value) {
            addCriterion("dishes_imageurl like", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlNotLike(String value) {
            addCriterion("dishes_imageurl not like", value, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlIn(List<String> values) {
            addCriterion("dishes_imageurl in", values, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlNotIn(List<String> values) {
            addCriterion("dishes_imageurl not in", values, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlBetween(String value1, String value2) {
            addCriterion("dishes_imageurl between", value1, value2, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesImageurlNotBetween(String value1, String value2) {
            addCriterion("dishes_imageurl not between", value1, value2, "dishesImageurl");
            return (Criteria) this;
        }

        public Criteria andDishesPriceIsNull() {
            addCriterion("dishes_price is null");
            return (Criteria) this;
        }

        public Criteria andDishesPriceIsNotNull() {
            addCriterion("dishes_price is not null");
            return (Criteria) this;
        }

        public Criteria andDishesPriceEqualTo(Integer value) {
            addCriterion("dishes_price =", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceNotEqualTo(Integer value) {
            addCriterion("dishes_price <>", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceGreaterThan(Integer value) {
            addCriterion("dishes_price >", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("dishes_price >=", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceLessThan(Integer value) {
            addCriterion("dishes_price <", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceLessThanOrEqualTo(Integer value) {
            addCriterion("dishes_price <=", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceIn(List<Integer> values) {
            addCriterion("dishes_price in", values, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceNotIn(List<Integer> values) {
            addCriterion("dishes_price not in", values, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceBetween(Integer value1, Integer value2) {
            addCriterion("dishes_price between", value1, value2, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("dishes_price not between", value1, value2, "dishesPrice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}