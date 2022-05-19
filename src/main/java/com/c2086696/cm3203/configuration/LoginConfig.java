package com.c2086696.cm3203.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    //Adding the login blocker in
    public void addInterceptors(InterceptorRegistry registry){
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        //Add paths that should be blocked addPathPatterns()
        registry.addInterceptor(loginInterceptor).addPathPatterns("/newArticle","/management");
    }
}
