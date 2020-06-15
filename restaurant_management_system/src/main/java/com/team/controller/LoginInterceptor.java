package com.team.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        if(requestUri.contains("/login")){
            return true;
        }else if(request.getSession().getAttribute("userAdmin") != null) {
            boolean pass = requestUri.contains("/Ingredient/")
                    || requestUri.contains("/Order/")
                    || requestUri.contains("/Shopping/");
            if(request.getSession().getAttribute("userAuth").equals(0) && pass){
                return true;
            }else if(request.getSession().getAttribute("userAuth").equals(1)){
                return true;
            }
            else {
                System.out.println("非法权限");
                return false;
            }
        } else {
            request.setAttribute("message","没有登录");
            System.out.println("没有登录");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
