package com.team.controller;

import com.google.gson.Gson;
import com.team.entity.Price;
import com.team.repository.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**控制菜单的增删改查
 * getDishes（get）
 * addDishes（post）
 * updateDishes（post）
 * deleteDishes（get）
 */
@RestController
@RequestMapping(value = "/Price")
public class PriceController {
    @Autowired
    private PriceMapper priceMapper;
    private final Gson gson = new Gson();

    /**获取所有的餐品
     * [{\"dishesId\":1,
     * \"dishesName\":\"红烧狮子头\",
     * \"dishesImageurl\":\"https://baike.baidu.com/pic/%E7%BA%A2%E7%83%A7%E7%8B%AE%E5%AD%90%E5%A4%B4/1652307/0/4d4970063e62e230030881e0?fr\=lemma\&ct\=single\",
     * \"dishesPrice\":25}]
     * @return
     */
    @GetMapping(value = "/getDishes")
    public String getDishes(){
        List<Price> priceList = priceMapper.selectAll();
        return gson.toJson(priceList);
    }

    /**添加菜单信息
     * {
     * 	"dishesName":"东坡肉",必须
     * 	"dishesImageurl":"https://baike.baidu.com/pic/%E4%B8%9C%E5%9D%A1%E8%82%89/120740/16593158/4bed2e738bd4b31c31e6eea18ad6277f9f2ff8d6?fr=lemma&ct=cover",
     * 	"dishesPrice":21必须
     * }
     * @param price
     * @return
     * {
     *  "dishesId":"1",
     * 	"dishesName":"东坡肉",
     * 	"dishesImageurl":"https://baike.baidu.com/pic/%E4%B8%9C%E5%9D%A1%E8%82%89/120740/16593158/4bed2e738bd4b31c31e6eea18ad6277f9f2ff8d6?fr=lemma&ct=cover",
     * 	"dishesPrice":21
     * }
     */
    @PostMapping(value = "/addDishes")
    public String addDishes(@RequestBody Price price){
        if(priceMapper.insert(price) > 0)
            return gson.toJson(price);
        else
            return "{\"dishesId\":-1}";
    }

    /**更新菜单
     *{
     * 	"dishesId":3,必须
     * 	"dishesName":"宫保鸡丁",不改
     * 	"dishesImageurl":"https://baike.baidu.com/pic/%E5%AE%AB%E4%BF%9D%E9%B8%A1%E4%B8%81/1570/0/00e93901213fb80e91f6c57635d12f2eb9389468?fr=lemma&ct=single",可选
     * 	"dishesPrice":27可选
     * }
     * 如果改菜品则直接删除
     * @param price
     * @return
     */
    @PostMapping(value = "/updateDishes")
    public String updateDishes(@RequestBody Price price){
        if(priceMapper.updateByPrimaryKeySelective(price) > 0)
            return gson.toJson(priceMapper.selectByPrimaryKey(price.getDishesId()));//修改有很多可选项所以必须查表
        else
            return "{\"dishesId\":-1}";
    }

    /**删除菜品，通过id删除
     *
     * @param dishesId
     * @return
     */
    @GetMapping(value = "/deleteDishes")
    public String deleteDishes(@RequestParam Integer dishesId){
        if(priceMapper.deleteByPrimaryKey(dishesId) > 0)
            return "{\"dishesId\":0}";
        else
            return "{\"dishesId\":-1}";
    }

}
