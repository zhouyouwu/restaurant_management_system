package com.zhouyouwu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = GET)
    public String start(){
        return "index";
    }
    
}
