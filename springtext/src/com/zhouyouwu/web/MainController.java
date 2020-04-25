package com.zhouyouwu.web;

import com.zhouyouwu.bean.CDPlayer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = GET)
    public String start(){
        CDPlayer player = new CDPlayer();
        player.play();

        return "index";
    }
    
}
