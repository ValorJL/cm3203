package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Repository.ArticleRepository;
import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @GetMapping("/login")
    public String login(){
        return"login";
    }

    @GetMapping("/signin")
    public String signin(){
        return "sign-in";
    }

    @GetMapping("/hello")
    public String hello(){
        return"hello";
    }

    @GetMapping("/home")
    public String home(){
        return"home";
    }

    @GetMapping("/welcome")
    public String wlecome(){
        return"welcome";
    }

    @GetMapping("/new-article")
    public String newArticle(){
        return"new-article";
    }

    @GetMapping("/01")
    public String test(){
        return"test01";
    }


}
