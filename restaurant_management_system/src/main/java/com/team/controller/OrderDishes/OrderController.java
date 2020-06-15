package com.team.controller.OrderDishes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team.entity.Order;
import com.team.repository.OrderMapper;
import com.team.service.OrderDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**订单控制，由于为了订单安全，所以没有设置修改方法，需要修改则删除，防止修改导致账目不对
 * getOrder（get）
 * addOrder（post）
 * deleteOrder（get）
 */
@RestController
@RequestMapping(value = "/Order")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    private final GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
    private final Gson gson = gsonBuilder.create();
    @Autowired
    private OrderDishesService orderDishesService;

    /**获取全部订单信息
     * 输入参数为空则获取全部订单
     * 输入对应日期则获取当日全部订单
     * @return
     * "[{\"orderId\":2,
     * \"orderDiscount\":10.0,
     * \"orderTotal\":21.0,
     * \"orderReceive\":50.0,
     * \"restaurantId\":1,
     * "cartId\":1,
     * \"orderDetails\":\"[{\\\"dishesName\\\":\\\"东坡肉\\\",
     *                       \\\"dishesPrice\\\":21,
     *                       \\\"dishesCount\\\":1}]\",
     * \"orderDate\":\"2020-06-10\"}]"
     */
    @GetMapping(value = "/getOrder")
    public String getOrder(@Nullable @RequestParam Date date){
        List<Order> orderList;
        if(date == null) {
            orderList = orderMapper.selectAll();
        }else {
            orderList = orderMapper.selectByDate(date);
        }
        return gson.toJson(orderList);
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
    @PostMapping(value = "/addOrder")
    public String addOrder(@RequestBody Order order){
        return orderDishesService.addOrder(order);
    }

    /**删除订单
     *
     * @param orderId
     * @return
     * 成功返回"{\"ingredientId\":0}"
     * 失败返回"{\"ingredientId\":-1}"
     */
    @GetMapping(value = "/deleteOrder")
    public String deleteOrder(@RequestParam Integer orderId){
        if(orderMapper.deleteByPrimaryKey(orderId) > 0){
            return "{\"orderId\":0}";
        }else {
            return "{\"orderId\":-1}";
        }
    }
}
