package com.zhouyouwu.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
public class Office {
    private String position = "校长";
    private Address address;

    public Office(Address address) {
        this.address = address;
    }

    public void show(){
        System.out.println("职位："+getPosition());
        address.show();
    }
}
