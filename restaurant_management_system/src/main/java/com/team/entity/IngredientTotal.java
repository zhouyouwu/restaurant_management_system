package com.team.entity;

import java.util.Date;

public class IngredientTotal {
    private Date ingredientDate;

    private String details;

    private Integer restaurantId;

    public Date getIngredientDate() {
        return ingredientDate;
    }

    public void setIngredientDate(Date ingredientDate) {
        this.ingredientDate = ingredientDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}