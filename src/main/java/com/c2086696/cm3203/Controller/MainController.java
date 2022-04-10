package com.c2086696.cm3203.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/welcome")
    public String wlecome(){
        return"welcome";
    }

    @GetMapping("/management")
    public String management(){
        return"management";
    }

    @GetMapping("/01")
    public String test(){
        return"test01";
    }

    @GetMapping("/02")
    public String test2(){
        return"test02";
    }


}
