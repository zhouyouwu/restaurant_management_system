package com.zhouyouwu.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Address {
    private String province = "四川";
    private String city = "成都";
    private String street = "红光大道";

    public void show(){
        System.out.println("工作地址："+province+"," +city+"," +street);
    }
}
