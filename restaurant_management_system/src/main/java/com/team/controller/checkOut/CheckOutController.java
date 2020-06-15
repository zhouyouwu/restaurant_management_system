package com.team.controller.checkOut;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.team.entity.Cart;
import com.team.entity.Price;
import com.team.repository.CartMapper;
import com.team.repository.PriceMapper;
import com.team.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/CheckOut")
public class CheckOutController {
    @Autowired
    private CartMapper cartMapper;
    private final Gson gson = new Gson();
    @Autowired
    private CheckOutService checkOutService;
    @Autowired
    private PriceMapper priceMapper;

    @GetMapping(value = "/checkOutByCustomer")
    public String checkOutByCustomer(@RequestParam Date date, @RequestParam Integer day){
        return checkOutService.checkOutByCustomer(date, day);
    }

    @GetMapping(value = "/checkOutByDishes")
    public String checkOutByDishes(@RequestParam Date date, @RequestParam Integer day, @RequestParam Integer dishesId){
        return checkOutService.checkOutByDishes(date, day, dishesId);
    }

    @GetMapping(value = "/test")
    public String test(){
        PageHelper.startPage(1,5,true);
        List<Cart> cartList = cartMapper.selectAll();
        System.out.println(gson.toJson(cartList));
        return "";
    }
}
