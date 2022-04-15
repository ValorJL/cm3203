package com.c2086696.cm3203.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    //将登录拦截器添加进来
    //addPathPatterns()添加拦截
    //excludePathPatterns()排除拦截
    public void addInterceptors(InterceptorRegistry registry){
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        //添加应该被拦截的路径 addPathPatterns()
        registry.addInterceptor(loginInterceptor).addPathPatterns("/welcome","/newArticle","/management");
    }
}
