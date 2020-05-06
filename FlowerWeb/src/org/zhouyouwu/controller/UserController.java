package org.zhouyouwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhouyouwu.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping(value = "/hello")
    public String hello(Model model){
        UserBean userBean = new UserBean();
        model.addAttribute("userBean", userBean);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response){
        String userId = request.getParameter("userId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    }
}
