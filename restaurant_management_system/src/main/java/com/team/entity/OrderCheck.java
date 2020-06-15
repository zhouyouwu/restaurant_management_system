package com.team.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderCheck {
    private List<Order> orderList;
    private Double total;
}
