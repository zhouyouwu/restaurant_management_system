package com.zhouyouwu.web;

import com.zhouyouwu.bean.CDPlayer;
import com.zhouyouwu.config.CDPlayerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = GET)
    public String start(ApplicationContext context){

        //ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CDPlayer cdPlayer = context.getBean(CDPlayer.class);
        cdPlayer.play();
        return "index";
    }
    
}
