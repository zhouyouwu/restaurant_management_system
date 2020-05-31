package com.zhouyouwu.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Car {
    private String trademark = "五菱宏光";
    private String price = "9998";

    public void show(){
        System.out.println("汽车商标："+getTrademark());
        System.out.println("汽车价格："+getPrice());
    }
}
