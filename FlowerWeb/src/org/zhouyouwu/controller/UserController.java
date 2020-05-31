package org.zhouyouwu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhouyouwu.beans.UserBean;
import org.zhouyouwu.mapper.UserMapper;
import org.zhouyouwu.service.RegisterService;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = "/hello")
    public String hello(Model model){
//        List<UserBean> userBeanList = RegisterService.selectUserList();
//        for(UserBean user: userBeanList){
//            System.out.println(user.getUserId());
//            System.out.println(user.getUsername());
//            System.out.println(user.getPassword());
//            System.out.println("");
//        }
//        UserBean user = RegisterService.selectUser("1247721255");
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
        return "register";
    }

    /**接收用户注册信息调用RegisterService
     *
     * @param user
     */
    @Valid
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@NonNull UserBean user){
        System.out.println(user.getUserId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        RegisterService.addUser(user);
        return "{\"message\":\"ok\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserBean userBean){
        String userId = userBean.getUserId();
        String password = userBean.getPassword();
        System.out.println(userId);
        UserBean dbUser = RegisterService.selectUser(userId);
        if(dbUser!=null){
            if(password.equals(dbUser.getPassword())){
                return "{\"message\":\"Login success\",\"username\":\""+dbUser.getUsername()+"\"}";
            }else {
                return "{\"message\":\"password err\"}";
            }
        }else {
            return "{\"message\":\"userId err\"}";
        }
    }
}
