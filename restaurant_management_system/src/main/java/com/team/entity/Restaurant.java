package com.team.entity;

public class Restaurant {
    private Integer restaurantId;

    private String restaurantName;

    private String restaurantAddress;

    private Long restaurantPhone;

    private Float discount;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName == null ? null : restaurantName.trim();
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress == null ? null : restaurantAddress.trim();
    }

    public Long getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(Long restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}