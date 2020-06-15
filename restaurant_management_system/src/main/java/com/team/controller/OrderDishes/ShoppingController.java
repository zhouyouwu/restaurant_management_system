package com.team.controller.OrderDishes;

import com.google.gson.Gson;
import com.team.entity.Shopping;
import com.team.repository.ShoppingMapper;
import com.team.service.OrderDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**添加点菜记录
 * getShopping（get）
 * addShopping（post）
 * updateShopping（post）
 * deleteShopping（post)
 */
@RestController
@RequestMapping(value = "/Shopping")
public class ShoppingController {
    @Autowired
    private OrderDishesService orderDishesService;
    private final Gson gson = new Gson();
    @Autowired
    private ShoppingMapper shoppingMapper;

    /**获取全部点菜记录
     * 根据购物车来显示
     * @param cartId
     * @return
     *[{\"shoppingId\":4,
     * \"cartId\":4,
     * \"dishesId\":5,
     * \"dishesCount\":1}]
     */
    @GetMapping(value = "getShopping")
    public String getShopping(@RequestParam Integer cartId){
        List<Shopping> shoppingList = shoppingMapper.selectByCartId(cartId);
        return gson.toJson(shoppingList);
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
    @PostMapping(value = "/addShopping")
    public String addShopping(@RequestBody Shopping shopping){
        return orderDishesService.addShopping(shopping);
    }

    /**更新购物记录
     * {
     * 	"dishesId":5,必须
     * 	"cartId":4,必须
     * 	"dishesCount":1必须
     * }
     * 根据购物车号和菜品号定位
     * 只更新数目，其他的用删除方法
     * @param shopping
     * @return
     */
    @PostMapping(value = "/updateShopping")
    public String updateShopping(@RequestBody Shopping shopping){
        if(shoppingMapper.updateCountByEntity(shopping) > 0)
            return "{\"shoppingId\":0}";
        else
            return "{\"shoppingId\":-1}";
    }

    /**删除购物记录
     * 此删除也是根据购物车和餐品来定位
     * {
     * 	"cartId":4,必须
     * 	"dishesId":3必须
     * }
     * @param shopping
     * @return
     */
    @PostMapping(value = "/deleteShopping")
    public String deleteShopping(@RequestBody Shopping shopping){
        if(shoppingMapper.deleteByEntity(shopping) > 0)
            return "{\"shoppingId\":0}";
        else
            return "{\"shoppingId\":-1}";
    }
}
