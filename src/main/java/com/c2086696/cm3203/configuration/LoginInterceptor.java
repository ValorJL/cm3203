package com.c2086696.cm3203.configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    //用于存储排除拦截的url
    private List<String> urls = new ArrayList<String>();

    //目标方法执行前，也就是进入控制器前，拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            //已登录
            return true;
        } else {
            //没有登录
            System.out.println("你还没登录，没有权限");
            request.setAttribute("msg","没有权限请先登陆");
            response.sendRedirect("/login");    //未登录，拦截跳转到登录页
            return false;

        }
    }
    //下面这个可以一会儿注释了看看有没有影响，没有就去掉了
    //设置能通过的url
//    public List<String> getUrls() {
//        urls.add("/login");   //login url请求
//
//        //静态资源
//        urls.add("/img/*");
//        urls.add("/js/*");
//        urls.add("/css/*");
//        return urls;
//    }

}
