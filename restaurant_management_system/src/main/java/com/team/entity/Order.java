package com.team.entity;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Float orderDiscount;

    private Float orderTotal;

    private Float orderReceive;

    private Integer restaurantId;

    private Integer cartId;

    private String orderDetails;

    private Date orderDate;

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

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails == null ? null : orderDetails.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}