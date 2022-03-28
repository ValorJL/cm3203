package com.c2086696.cm3203.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/welcome")
    public String wlecome(){
        return"welcome";
    }

    @GetMapping("/01")
    public String test(){
        return"test01";
    }


}
