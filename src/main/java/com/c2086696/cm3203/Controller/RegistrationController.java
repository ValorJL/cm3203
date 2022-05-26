package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.DAO.User;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute("user") User user,Model model) {
        //If this name exists, return null
        if (!userService.findByName(user.getName()).isEmpty()) {
            model.addAttribute("unsuccessMessage", "This username has already been registered");
            return "/registration";
        }
        userService.saveUser(user);
        model.addAttribute("successMessage", "The user has been registered successfully");
        return "/registration";
    }
}