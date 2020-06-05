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
import org.springframework.web.bind.annotation.*;

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
    private int flog;

    @GetMapping(value = "/getOrder")
    public String getOrder(){
        List<Order> orderList = orderMapper.selectAll();
        return gson.toJson(orderList);
    }

    @PostMapping(value = "/addOrder")
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
            flog = orderMapper.insert(order);
            if (flog > 0){
                return gson.toJson(orderMapper.selectByPrimaryKey(order.getOrderId()));
            }else {
                return "{\"orderId\":-1}";
            }

        }else {
            return "{\"orderId\":-1,\"total\":"+orderTotal*order.getOrderDiscount()*0.1+"}";
        }
    }

    @GetMapping(value = "/deleteOrder")
    public String deleteOrder(@RequestParam Integer orderId){
        flog = orderMapper.deleteByPrimaryKey(orderId);
        if(flog > 0){
            return "{\"orderId\":0}";
        }else {
            return "{\"orderId\":-1}";
        }
    }
}
