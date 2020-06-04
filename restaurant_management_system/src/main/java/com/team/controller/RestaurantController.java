package com.team.controller;

import com.google.gson.Gson;
import com.team.entity.Restaurant;
import com.team.repository.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**主要用于餐厅信息的管理
 * 获取所有餐厅信息getRestaurant
 * 增加餐厅addRestaurant
 * 更新餐厅信息updateRestaurant
 * 删除餐厅deleteRestaurant
 */
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantMapper restaurantMapper;
    private final Gson gson = new Gson();

    /**get请求直接获取json
     *格式如下
     * @return
     * [
     *     {
     *         "restaurantId": 1,
     *         "restaurantName": "中餐厅",
     *         "restaurantAddress": "四川省会东县",
     *         "restaurantPhone": 13356478914,
     *         "discount": 8.0
     *     }
     * ]
     */
    @GetMapping(value = "/getRestaurant")
    public String getRestaurant(){
        List<Restaurant> restaurantList = restaurantMapper.selectAll();
        return gson.toJson(restaurantList);
    }

    /**post请求添加餐厅，序号数据库自增
     *
     * @param restaurant
     * json数据不用编号
     * {
     *      "restaurantName": "中餐厅",
     *      "restaurantAddress": "四川省会东县",
     *      "restaurantPhone": 13356478914,
     *      "discount": 8.0
     * }
     * @return
     * 成功则返回新餐厅的json数据含id
     * 失败则返回{"restaurantId": -1}
     */
    @PostMapping(value = "/addRestaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        int flog = restaurantMapper.insert(restaurant);
        if(flog > 0){
            return gson.toJson(restaurantMapper.selectByPrimaryKey(restaurant.getRestaurantId()));
        }else {
            return "{\"restaurantId\": -1}";
        }
    }

    /**post请求更新餐厅信息
     *
     * @param restaurant
     * 需要根据id来确定餐厅项，故json数据需要包含id
     * @return
     * 同add请求
     */
    @PostMapping(value = "updateRestaurant")
    public String updateRestaurant(@RequestBody Restaurant restaurant){
        int flog = restaurantMapper.updateByPrimaryKey(restaurant);
        if(flog > 0){
            return gson.toJson(restaurantMapper.selectByPrimaryKey(restaurant.getRestaurantId()));
        }else {
            return "{\"restaurantId\": -1}";
        }
    }

    /**post请求删除餐厅信息
     *
     * @param restaurant
     * 需要根据id来确定餐厅项，故json数据需要包含id
     * @return
     * 删除成功收到id为0，删除失败收到id为-1
     */
    @PostMapping(value = "/deleteRestaurant")
    public String deleteRestaurant(@RequestBody Restaurant restaurant){
        int flog = restaurantMapper.deleteByPrimaryKey(restaurant.getRestaurantId());
        if(flog > 0){
            return "{\"restaurantId\": 0}";
        }else {
            return "{\"restaurantId\": -1}";
        }
    }
}
