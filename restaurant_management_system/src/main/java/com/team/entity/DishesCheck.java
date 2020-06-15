package com.team.entity;

import lombok.Data;

import java.util.List;

@Data
public class DishesCheck {
    private List<ShoppingDishes> dishes;
    private double total;
}
