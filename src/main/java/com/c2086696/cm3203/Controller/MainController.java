package com.c2086696.cm3203.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/01")
    public String test(){
        return"test01";
    }


}
