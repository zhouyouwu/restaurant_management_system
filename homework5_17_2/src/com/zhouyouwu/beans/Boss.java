package com.zhouyouwu.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
public class Boss {
    private Car car;
    private Office office;

    public Boss(Car car, Office office) {
        this.car = car;
        this.office = office;
    }

    public void show(){
        car.show();
        office.show();
    }
}
