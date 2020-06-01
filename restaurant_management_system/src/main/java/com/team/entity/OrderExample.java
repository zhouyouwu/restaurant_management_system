package com.team.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIsNull() {
            addCriterion("order_discount is null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIsNotNull() {
            addCriterion("order_discount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountEqualTo(Float value) {
            addCriterion("order_discount =", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotEqualTo(Float value) {
            addCriterion("order_discount <>", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountGreaterThan(Float value) {
            addCriterion("order_discount >", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("order_discount >=", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountLessThan(Float value) {
            addCriterion("order_discount <", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountLessThanOrEqualTo(Float value) {
            addCriterion("order_discount <=", value, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountIn(List<Float> values) {
            addCriterion("order_discount in", values, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotIn(List<Float> values) {
            addCriterion("order_discount not in", values, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountBetween(Float value1, Float value2) {
            addCriterion("order_discount between", value1, value2, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderDiscountNotBetween(Float value1, Float value2) {
            addCriterion("order_discount not between", value1, value2, "orderDiscount");
            return (Criteria) this;
        }

        public Criteria andOrderTotalIsNull() {
            addCriterion("order_total is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalIsNotNull() {
            addCriterion("order_total is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalEqualTo(Float value) {
            addCriterion("order_total =", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalNotEqualTo(Float value) {
            addCriterion("order_total <>", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalGreaterThan(Float value) {
            addCriterion("order_total >", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("order_total >=", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalLessThan(Float value) {
            addCriterion("order_total <", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalLessThanOrEqualTo(Float value) {
            addCriterion("order_total <=", value, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalIn(List<Float> values) {
            addCriterion("order_total in", values, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalNotIn(List<Float> values) {
            addCriterion("order_total not in", values, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalBetween(Float value1, Float value2) {
            addCriterion("order_total between", value1, value2, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderTotalNotBetween(Float value1, Float value2) {
            addCriterion("order_total not between", value1, value2, "orderTotal");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIsNull() {
            addCriterion("order_receive is null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIsNotNull() {
            addCriterion("order_receive is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveEqualTo(Float value) {
            addCriterion("order_receive =", value, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNotEqualTo(Float value) {
            addCriterion("order_receive <>", value, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveGreaterThan(Float value) {
            addCriterion("order_receive >", value, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveGreaterThanOrEqualTo(Float value) {
            addCriterion("order_receive >=", value, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveLessThan(Float value) {
            addCriterion("order_receive <", value, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveLessThanOrEqualTo(Float value) {
            addCriterion("order_receive <=", value, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIn(List<Float> values) {
            addCriterion("order_receive in", values, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNotIn(List<Float> values) {
            addCriterion("order_receive not in", values, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveBetween(Float value1, Float value2) {
            addCriterion("order_receive between", value1, value2, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNotBetween(Float value1, Float value2) {
            addCriterion("order_receive not between", value1, value2, "orderReceive");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdIsNull() {
            addCriterion("restaurant_id is null");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdIsNotNull() {
            addCriterion("restaurant_id is not null");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdEqualTo(Integer value) {
            addCriterion("restaurant_id =", value, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdNotEqualTo(Integer value) {
            addCriterion("restaurant_id <>", value, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdGreaterThan(Integer value) {
            addCriterion("restaurant_id >", value, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("restaurant_id >=", value, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdLessThan(Integer value) {
            addCriterion("restaurant_id <", value, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdLessThanOrEqualTo(Integer value) {
            addCriterion("restaurant_id <=", value, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdIn(List<Integer> values) {
            addCriterion("restaurant_id in", values, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdNotIn(List<Integer> values) {
            addCriterion("restaurant_id not in", values, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdBetween(Integer value1, Integer value2) {
            addCriterion("restaurant_id between", value1, value2, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andRestaurantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("restaurant_id not between", value1, value2, "restaurantId");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
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