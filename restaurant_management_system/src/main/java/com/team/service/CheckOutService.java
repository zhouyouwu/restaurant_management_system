package com.team.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team.entity.DishesCheck;
import com.team.entity.Order;
import com.team.entity.OrderCheck;
import com.team.entity.ShoppingDishes;
import com.team.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class CheckOutService {
    private final OrderMapper orderMapper;
    private final GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
    private final Gson gson = gsonBuilder.create();

    @Autowired
    public CheckOutService(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    public OrderCheck checkOutByDate(Date orderDate){
        double total = 0;
        List<Order> orderList = orderMapper.selectByDate(orderDate);
        for(Order order:orderList){
            total += order.getOrderTotal();
        }
        OrderCheck orderCheck = new OrderCheck();
        orderCheck.setOrderList(orderList);
        orderCheck.setTotal(total);
        return orderCheck;
    }

    public String checkOutByCustomer(Date start, int day){
        List<Order> orderList = new ArrayList<>();
        double total = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        for(int i=0; i<day; i++){
            OrderCheck orderCheck = checkOutByDate(new Date(calendar.getTimeInMillis()));
            total += orderCheck.getTotal();
            orderList.addAll(orderCheck.getOrderList());
            calendar.add(Calendar.DATE,1);
        }
        OrderCheck orderCheck = new OrderCheck();
        orderCheck.setOrderList(orderList);
        orderCheck.setTotal(total);
        return gson.toJson(orderCheck);
    }

    public DishesCheck checkOutByDate(Date date, Integer dishesId){
        List<ShoppingDishes> dishesList = orderMapper.selectByDateDishesId(date, dishesId);
        float total = 0;
        for(ShoppingDishes dishes:dishesList){
            total += dishes.getTotal();
        }
        DishesCheck dishesCheck = new DishesCheck();
        dishesCheck.setDishes(dishesList);
        dishesCheck.setTotal(total);
        return dishesCheck;
    }

    public String checkOutByDishes(Date start, int day, Integer dishesId){
        List<ShoppingDishes> dishesList = new ArrayList<>();
        double total = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        for(int i=0; i<day; i++){
            DishesCheck dishesCheck = checkOutByDate(new Date(calendar.getTimeInMillis()), dishesId);
            total += dishesCheck.getTotal();
            dishesList.addAll(dishesCheck.getDishes());
            calendar.add(Calendar.DATE,1);
        }
        DishesCheck dishesCheck = new DishesCheck();
        dishesCheck.setDishes(dishesList);
        dishesCheck.setTotal(total);
        return gson.toJson(dishesCheck);
    }


    /**检查restaurantid问题，现在以一个餐厅为准，取消多个餐厅设定
     * 拦截器有更改要改回来才对
     */
}
