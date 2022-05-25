package com.c2086696.cm3203.Configuration;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    //Before the target method is executed, i.e. before it enters the controller, intercept
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            //Logged in
            return true;
        } else {
            //Not logged in
            System.out.println("You haven't logined in");
            request.setAttribute("msg","Please Login in first");
            response.sendRedirect("/login");    //Not logged in, intercept jump to login page
            return false;

        }
    }

}
