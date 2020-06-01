package com.team.entity;

import java.util.Date;

public class IngredientDay {
    private Integer ingredientId;

    private Date ingredientDate;

    private String ingredientName;

    private Float ingredientCount;

    private Float ingredientPrice;

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Date getIngredientDate() {
        return ingredientDate;
    }

    public void setIngredientDate(Date ingredientDate) {
        this.ingredientDate = ingredientDate;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName == null ? null : ingredientName.trim();
    }

    public Float getIngredientCount() {
        return ingredientCount;
    }

    public void setIngredientCount(Float ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    public Float getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(Float ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }
}