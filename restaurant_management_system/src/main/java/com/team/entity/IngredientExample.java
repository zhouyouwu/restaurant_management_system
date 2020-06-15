package com.team.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IngredientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IngredientExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIngredientIdIsNull() {
            addCriterion("ingredient_id is null");
            return (Criteria) this;
        }

        public Criteria andIngredientIdIsNotNull() {
            addCriterion("ingredient_id is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientIdEqualTo(Integer value) {
            addCriterion("ingredient_id =", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotEqualTo(Integer value) {
            addCriterion("ingredient_id <>", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdGreaterThan(Integer value) {
            addCriterion("ingredient_id >", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ingredient_id >=", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdLessThan(Integer value) {
            addCriterion("ingredient_id <", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdLessThanOrEqualTo(Integer value) {
            addCriterion("ingredient_id <=", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdIn(List<Integer> values) {
            addCriterion("ingredient_id in", values, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotIn(List<Integer> values) {
            addCriterion("ingredient_id not in", values, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdBetween(Integer value1, Integer value2) {
            addCriterion("ingredient_id between", value1, value2, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ingredient_id not between", value1, value2, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientDateIsNull() {
            addCriterion("ingredient_date is null");
            return (Criteria) this;
        }

        public Criteria andIngredientDateIsNotNull() {
            addCriterion("ingredient_date is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientDateEqualTo(Date value) {
            addCriterionForJDBCDate("ingredient_date =", value, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ingredient_date <>", value, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ingredient_date >", value, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ingredient_date >=", value, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateLessThan(Date value) {
            addCriterionForJDBCDate("ingredient_date <", value, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ingredient_date <=", value, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateIn(List<Date> values) {
            addCriterionForJDBCDate("ingredient_date in", values, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ingredient_date not in", values, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ingredient_date between", value1, value2, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ingredient_date not between", value1, value2, "ingredientDate");
            return (Criteria) this;
        }

        public Criteria andIngredientNameIsNull() {
            addCriterion("ingredient_name is null");
            return (Criteria) this;
        }

        public Criteria andIngredientNameIsNotNull() {
            addCriterion("ingredient_name is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientNameEqualTo(String value) {
            addCriterion("ingredient_name =", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotEqualTo(String value) {
            addCriterion("ingredient_name <>", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameGreaterThan(String value) {
            addCriterion("ingredient_name >", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameGreaterThanOrEqualTo(String value) {
            addCriterion("ingredient_name >=", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameLessThan(String value) {
            addCriterion("ingredient_name <", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameLessThanOrEqualTo(String value) {
            addCriterion("ingredient_name <=", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameLike(String value) {
            addCriterion("ingredient_name like", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotLike(String value) {
            addCriterion("ingredient_name not like", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameIn(List<String> values) {
            addCriterion("ingredient_name in", values, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotIn(List<String> values) {
            addCriterion("ingredient_name not in", values, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameBetween(String value1, String value2) {
            addCriterion("ingredient_name between", value1, value2, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotBetween(String value1, String value2) {
            addCriterion("ingredient_name not between", value1, value2, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientCountIsNull() {
            addCriterion("ingredient_count is null");
            return (Criteria) this;
        }

        public Criteria andIngredientCountIsNotNull() {
            addCriterion("ingredient_count is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientCountEqualTo(Float value) {
            addCriterion("ingredient_count =", value, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountNotEqualTo(Float value) {
            addCriterion("ingredient_count <>", value, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountGreaterThan(Float value) {
            addCriterion("ingredient_count >", value, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountGreaterThanOrEqualTo(Float value) {
            addCriterion("ingredient_count >=", value, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountLessThan(Float value) {
            addCriterion("ingredient_count <", value, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountLessThanOrEqualTo(Float value) {
            addCriterion("ingredient_count <=", value, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountIn(List<Float> values) {
            addCriterion("ingredient_count in", values, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountNotIn(List<Float> values) {
            addCriterion("ingredient_count not in", values, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountBetween(Float value1, Float value2) {
            addCriterion("ingredient_count between", value1, value2, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientCountNotBetween(Float value1, Float value2) {
            addCriterion("ingredient_count not between", value1, value2, "ingredientCount");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceIsNull() {
            addCriterion("ingredient_price is null");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceIsNotNull() {
            addCriterion("ingredient_price is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceEqualTo(Float value) {
            addCriterion("ingredient_price =", value, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceNotEqualTo(Float value) {
            addCriterion("ingredient_price <>", value, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceGreaterThan(Float value) {
            addCriterion("ingredient_price >", value, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("ingredient_price >=", value, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceLessThan(Float value) {
            addCriterion("ingredient_price <", value, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceLessThanOrEqualTo(Float value) {
            addCriterion("ingredient_price <=", value, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceIn(List<Float> values) {
            addCriterion("ingredient_price in", values, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceNotIn(List<Float> values) {
            addCriterion("ingredient_price not in", values, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceBetween(Float value1, Float value2) {
            addCriterion("ingredient_price between", value1, value2, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andIngredientPriceNotBetween(Float value1, Float value2) {
            addCriterion("ingredient_price not between", value1, value2, "ingredientPrice");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseIsNull() {
            addCriterion("add_decrease is null");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseIsNotNull() {
            addCriterion("add_decrease is not null");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseEqualTo(Integer value) {
            addCriterion("add_decrease =", value, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseNotEqualTo(Integer value) {
            addCriterion("add_decrease <>", value, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseGreaterThan(Integer value) {
            addCriterion("add_decrease >", value, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_decrease >=", value, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseLessThan(Integer value) {
            addCriterion("add_decrease <", value, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseLessThanOrEqualTo(Integer value) {
            addCriterion("add_decrease <=", value, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseIn(List<Integer> values) {
            addCriterion("add_decrease in", values, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseNotIn(List<Integer> values) {
            addCriterion("add_decrease not in", values, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseBetween(Integer value1, Integer value2) {
            addCriterion("add_decrease between", value1, value2, "addDecrease");
            return (Criteria) this;
        }

        public Criteria andAddDecreaseNotBetween(Integer value1, Integer value2) {
            addCriterion("add_decrease not between", value1, value2, "addDecrease");
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