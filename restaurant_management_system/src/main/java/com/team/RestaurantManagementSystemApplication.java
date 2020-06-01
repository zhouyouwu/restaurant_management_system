package com.team;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.team.repository")
public class RestaurantManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagementSystemApplication.class, args);
    }

}
