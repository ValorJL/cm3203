package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "/login";
    }

    @RequestMapping(value = {"/loginVerify"}, method = RequestMethod.POST)
    public String login(String username,String password, Model model, HttpServletRequest request) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        boolean verify = userService.verifyLogin(user);
        if (verify) {
            model.addAttribute("loginUser",user);
            request.getSession().setAttribute("loginUser", user);
            return "redirect:/welcome";
        } else {
            return "redirect:/login";
        }
    }
}
