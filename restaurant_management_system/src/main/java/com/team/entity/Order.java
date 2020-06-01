package com.team.entity;

public class Order {
    private Integer orderId;

    private Float orderDiscount;

    private Float orderTotal;

    private Float orderReceive;

    private Integer restaurantId;

    private Integer cartId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Float getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Float orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Float getOrderReceive() {
        return orderReceive;
    }

    public void setOrderReceive(Float orderReceive) {
        this.orderReceive = orderReceive;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}