package com.team.service;

import com.google.gson.Gson;
import com.team.entity.*;
import com.team.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDishesService {
    private final Gson gson = new Gson();
    private final CartMapper cartMapper;
    private final ShoppingMapper shoppingMapper;
    private final PriceMapper priceMapper;
    private final OrderMapper orderMapper;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public OrderDishesService(CartMapper cartMapper, ShoppingMapper shoppingMapper, PriceMapper priceMapper
            , OrderMapper orderMapper, RestaurantMapper restaurantMapper){
        this.cartMapper = cartMapper;
        this.shoppingMapper = shoppingMapper;
        this.priceMapper = priceMapper;
        this.restaurantMapper = restaurantMapper;
        this.orderMapper = orderMapper;

    }

    /**添加点菜记录
     * {
     * 	"dishesId":1,
     * 	"cartId":3,可选项，如果没有则添加进新购物车
     * 	"dishesCount":2
     * }
     * @param shopping
     * @return
     * 第一次添加购物车则返回购物车编号
     * 添加购物记录失败则返回shopping=-1
     * 添加购物车失败则返回cartId=-1
     */
    public String addShopping(Shopping shopping){
        if(shopping.getCartId() == null){
            Cart cart = new Cart();
            cart.setCartId(0);
            if(cartMapper.insert(cart) > 0){
                shopping.setCartId(cart.getCartId());
                if(shoppingMapper.insert(shopping) > 0)
                    return gson.toJson(cart);
                else
                    return "{\"shoppingId\":-1}";
            }else {
                return "{\"cartId\":-1}";
            }
        }else {
            if(shoppingMapper.insert(shopping) > 0)
                return "{\"shoppingId\":0}";
            else
                return "{\"shoppingId\":-1}";
        }
    }

    /**添加订单，当前端把点餐信息计算好提交，验证。如果无误则添加
     * {
     * 	"orderTotal":71,
     * 	"orderReceive":50,
     * 	"restaurantId":1,
     * 	"cartId":3
     * }
     * 打折信息后台直接获取orderDiscount不用选择
     * @param order
     * @return
     * 返回订单全部信息
     * 如果添加订单出错"{\"orderId\":-1}"
     * 如果前后端数据不一致"{\"orderId\":-1,\"total\":80}"
     */
    public String addOrder(Order order){
        List<Shopping> shoppingList = shoppingMapper.selectByCartId(order.getCartId());
        List<OrderDetails> details = new ArrayList<>();
        float orderTotal = 0;
        //把购物车中餐品加起来
        for(Shopping shopping:shoppingList){
            int dishesId = shopping.getDishesId();
            Price dishes = priceMapper.selectByPrimaryKey(dishesId);
            int dishesPrice = dishes.getDishesPrice();
            orderTotal += (dishesPrice*shopping.getDishesCount());
            //添加详细信息
            OrderDetails detail = new OrderDetails();
            detail.setDishesName(dishes.getDishesName());
            detail.setDishesPrice(dishes.getDishesPrice());
            detail.setDishesCount(shopping.getDishesCount());
            details.add(detail);
        }

        //获取餐厅的折扣
        order.setOrderDiscount(restaurantMapper.selectByPrimaryKey(order.getRestaurantId()).getDiscount());
        if(order.getOrderTotal() == orderTotal*order.getOrderDiscount()*0.1){
            order.setOrderDetails(gson.toJson(details));
            order.setOrderDate(new Date(System.currentTimeMillis()));
            if (orderMapper.insert(order) > 0){
                return gson.toJson(order);
            }else {
                return "{\"orderId\":-1}";
            }
        }else {
            return "{\"orderId\":-1,\"total\":"+orderTotal*order.getOrderDiscount()*0.1+"}";
        }
    }
}
