package com.zhouyouwu.controller;

import com.zhouyouwu.beans.Boss;
import com.zhouyouwu.config.BossConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Controller
@ComponentScan("com.zhouyouwu.beans")
public class HelloWorldController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(Model model){
        ApplicationContext context = new AnnotationConfigApplicationContext(BossConfig.class);
        Boss boss = context.getBean(Boss.class);
        boss.show();
        System.out.println("ok");
        model.addAttribute("Boss",boss);
        return "index";
    }
}
