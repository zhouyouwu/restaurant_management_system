package org.zhouyouwu.controller;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhouyouwu.beans.UserBean;
import org.zhouyouwu.service.RegisterService;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = "/hello")
    public String hello(Model model){
        List<UserBean> userBeanList = RegisterService.selectUserList();
        for(UserBean user: userBeanList){
            System.out.println(user.getUserId());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println("");
        }
        UserBean user = RegisterService.selectUser("1247721255");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "register";
    }

    /**接收用户注册信息调用RegisterService
     *
     * @param user
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@NonNull UserBean user){
        System.out.println(user.getUserId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        RegisterService.addUser(user);
    }
}
