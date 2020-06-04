package com.team.controller;

import com.google.gson.Gson;
import com.team.entity.Cart;
import com.team.entity.Price;
import com.team.entity.Shopping;
import com.team.repository.CartMapper;
import com.team.repository.PriceMapper;
import com.team.repository.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;
    private final Gson gson = new Gson();
    private int flog;

    @GetMapping(value = "getShopping")
    public String getShopping(@RequestParam Integer cartId){
        List<Shopping> shoppingList = shoppingMapper.selectByCartId(cartId);
        return gson.toJson(shoppingList);
    }

    @PostMapping(value = "/addShopping")
    public String addShopping(@RequestBody Shopping shopping){
        if(shopping.getCartId() == null){
            Cart cart = new Cart();
            cart.setCartId(0);
            flog = cartMapper.insert(cart);
            int flog2 = shoppingMapper.insert(shopping);
            if(flog > 0 && flog2 > 0){
                return gson.toJson(cart);
            }else {
                return "{\"cartId\":-1}";
            }
        }else {
            flog = shoppingMapper.insert(shopping);
            if(flog > 0){
                return "{\"shoppingId\":0}";
            }else {
                return "{\"shoppingId\":-1}";
            }
        }
    }

    @PostMapping(value = "/updateShopping")
    public String updateShopping(@RequestBody Shopping shopping){
        flog = shoppingMapper.updateCountByEntity(shopping);
        if(flog > 0){
            return "{\"shoppingId\":0}";
        }else {
            return "{\"shoppingId\":-1}";
        }
    }

    @PostMapping(value = "/deleteShopping")
    public String deleteShopping(@RequestBody Shopping shopping){
        flog = shoppingMapper.deleteByEntity(shopping);
        if(flog > 0){
            return "{\"shoppingId\":0}";
        }else {
            return "{\"shoppingId\":-1}";
        }
    }
}
