package com.team.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.team.entity.User;
import com.team.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**用于控制用户信息
 * 有getUser展示全体用户信息（get）
 * addUser添加用户（post）
 * updateUser更新用户信息（post）
 * delete删除用户（get)
 * login（post）
 * logout（get）
 */
@RestController
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    private final GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
    private final Gson gson = gsonBuilder.create();

    /**用户信息获取，无参数，返回全部json信息
     * @return
     * [{
     * 	"userId": 3,
     * 	"password": "99887755zcy",
     * 	"authority": 0,
     * 	"entryDate": "2020-06-03",
     * 	"workDate": 0,
     * 	"salary": 2500,
     * 	"restaurantId": 1
     * }]
     */
    @GetMapping(value = "/getUser")
    public String getUser(){
        List<User> userList = userMapper.selectAll();
        return gson.toJson(userList);
    }

    /**添加用户，输入json数据为
     * {
     * 	"password":"99887755zcy",
     * 	"authority":0,
     * 	"workDate":0,
     * 	"salary":2500,
     * 	"restaurantId":1
     * }
     * 用户id自增，入职日期根据当天生成，如果不对可以update修改
     * @param user
     * @return
     * 成功返回新增user的全部信息
     * 失败返回userId为-1
     */
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user){
        user.setEntryDate(new Date(System.currentTimeMillis()));
        int flog = userMapper.insert(user);
        if(flog > 0){
            return gson.toJson(userMapper.selectByPrimaryKey(user.getUserId()));
        }else {
            return "{\"userId\": -1}";
        }
    }

    /**更新用户信息
     * 输入用户全部信息以作修改
     * id为修改的关键，无id则返回错误信息
     * @param user
     * @return
     * 同add方法
     */
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestBody User user){
        if(user.getUserId() == null){
            return "{\"restaurantId\": -1,\"message\":\"没有userId\"}";
        }
        int flog = userMapper.updateByPrimaryKeySelective(user);
        if(flog > 0){
            return gson.toJson(userMapper.selectByPrimaryKey(user.getUserId()));
        }else {
            return "{\"userId\": -1,\"message\":\"没有成功\"}";
        }
    }

    /**删除用户
     * 参数可以只传id
     * @param userId
     * @return
     * 成功则返回用户id为0
     * 失败则返回用户id为-1
     */
    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam Integer userId){
        int flog = userMapper.deleteByPrimaryKey(userId);
        if(flog > 0){
            return "{\"userId\": 0}";
        }else {
            return "{\"userId\": -1}";
        }
    }

    /**登录
     *
     * @param user
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody User user, HttpServletRequest request){
        User dbUser = userMapper.selectByPrimaryKey(user.getUserId());
        if(dbUser == null)
            return "{\"message\":\"用户名不存在\"}";
        else if(dbUser.getPassword().equals(user.getPassword())){
            request.getSession().setAttribute("userAdmin", dbUser.getUserId());
            request.getSession().setAttribute("userAuth", dbUser.getAuthority());
            return "{\"message\":\"登录成功\"}";
        }else {
            return "{\"message\":\"密码错误\"}";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("userAuth");
        return "{\"message\":\"退出成功\"}";
    }

}
