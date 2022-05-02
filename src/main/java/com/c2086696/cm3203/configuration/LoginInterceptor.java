package com.c2086696.cm3203.configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    //目标方法执行前，也就是进入控制器前，拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            //已登录
            return true;
        } else {
            //没有登录
            System.out.println("You haven't logined in");
            request.setAttribute("msg","Please Login in first");
            response.sendRedirect("/login");    //未登录，拦截跳转到登录页
            return false;

        }
    }

}
