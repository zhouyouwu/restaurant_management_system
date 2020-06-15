package com.team.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class ShoppingDishes {
    private Date date;
    private String dishes;
    private int count;
    private float price;
    private float total;
}
