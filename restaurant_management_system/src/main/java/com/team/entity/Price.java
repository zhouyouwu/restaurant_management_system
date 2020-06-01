package com.team.entity;

public class Price {
    private Integer dishesId;

    private String dishesName;

    private String dishesImageurl;

    private Integer dishesPrice;

    public Integer getDishesId() {
        return dishesId;
    }

    public void setDishesId(Integer dishesId) {
        this.dishesId = dishesId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName == null ? null : dishesName.trim();
    }

    public String getDishesImageurl() {
        return dishesImageurl;
    }

    public void setDishesImageurl(String dishesImageurl) {
        this.dishesImageurl = dishesImageurl == null ? null : dishesImageurl.trim();
    }

    public Integer getDishesPrice() {
        return dishesPrice;
    }

    public void setDishesPrice(Integer dishesPrice) {
        this.dishesPrice = dishesPrice;
    }
}