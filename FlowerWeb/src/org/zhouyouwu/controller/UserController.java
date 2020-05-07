package org.zhouyouwu.controller;

import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhouyouwu.beans.UserBean;
import org.zhouyouwu.service.RegisterService;

@Controller
public class UserController {
    @RequestMapping(value = "/hello")
    public String hello(Model model){
        UserBean userBean = new UserBean();
        model.addAttribute("userBean", userBean);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(UserBean userBean){
        //System.out.println(userBean.getUserId());
        //System.out.println(userBean.getUsername());
        //System.out.println(userBean.getPassword());
        System.out.println(userBean.getUserId());
        //RegisterService.addUser(user);
        //RegisterService.selectUser();
    }
}
