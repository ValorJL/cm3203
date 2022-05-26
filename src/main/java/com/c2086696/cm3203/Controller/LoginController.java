package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.DAO.User;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
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
            request.getSession().setAttribute("loginName",username);
            return "redirect:/welcome";
        } else {
            model.addAttribute("unsuccessMessage", "Incorrect username or password");
            return "/login";
        }
    }
}
