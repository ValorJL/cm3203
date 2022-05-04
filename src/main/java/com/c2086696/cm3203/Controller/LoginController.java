package com.c2086696.cm3203.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Principal principal) {
        if (principal!=null){
            return "redirect:/";
        }else{
            return "login";
        }
    }

}
