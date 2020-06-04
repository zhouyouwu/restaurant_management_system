package com.team.controller;

import com.google.gson.Gson;
import com.team.entity.Price;
import com.team.repository.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {
    @Autowired
    private PriceMapper priceMapper;
    private final Gson gson = new Gson();
    private int flog;

    @GetMapping(value = "/getDishes")
    public String getDishes(){
        List<Price> priceList = priceMapper.selectAll();
        return gson.toJson(priceList);
    }

    @PostMapping(value = "/addDishes")
    public String addDishes(@RequestBody Price price){
        flog = priceMapper.insert(price);
        if(flog > 0){
            return gson.toJson(priceMapper.selectByPrimaryKey(price.getDishesId()));
        }else {
            return "{\"dishesId\":-1}";
        }
    }

    @PostMapping(value = "/updateDishes")
    public String updateDishes(@RequestBody Price price){
        flog = priceMapper.updateByPrimaryKey(price);
        if(flog > 0){
            return gson.toJson(priceMapper.selectByPrimaryKey(price.getDishesId()));
        }else {
            return "{\"dishesId\":-1}";
        }
    }

    @PostMapping(value = "/deleteDishes")
    public String deleteDishes(@RequestBody Price price){
        flog = priceMapper.deleteByPrimaryKey(price.getDishesId());
        if(flog > 0){
            return "{\"dishesId\":0}";
        }else {
            return "{\"dishesId\":-1}";
        }
    }

}
