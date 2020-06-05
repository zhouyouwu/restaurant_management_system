package com.team.controller;

import com.google.gson.Gson;
import com.team.entity.Order;
import com.team.entity.Price;
import com.team.entity.Shopping;
import com.team.repository.OrderMapper;
import com.team.repository.PriceMapper;
import com.team.repository.RestaurantMapper;
import com.team.repository.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private RestaurantMapper restaurantMapper;
    private final Gson gson = new Gson();

    @GetMapping(value = "/addOrder")
    public String addOrder(@RequestBody Order order){
        List<Shopping> shoppingList = shoppingMapper.selectByCartId(order.getCartId());
        float orderTotal = 0;
        for(Shopping shopping:shoppingList){
            int dishesId = shopping.getDishesId();
            Price dishes = priceMapper.selectByPrimaryKey(dishesId);
            int dishesPrice = dishes.getDishesPrice();
            orderTotal += (dishesPrice*shopping.getDishesCount());
        }

        order.setOrderDiscount(restaurantMapper.selectByPrimaryKey(order.getRestaurantId()).getDiscount());
        if(order.getOrderTotal() == orderTotal*order.getOrderDiscount()*0.1){
            orderMapper.insert(order);
            return gson.toJson(orderMapper.selectByPrimaryKey(order.getOrderId()));
        }else {
            return "{\"orderId\":-1,\"total\":"+orderTotal*order.getOrderDiscount()*0.1+"}";
        }
    }
}
