package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.DAO.User;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(User user, Model model) {
        if (!userService.findByUsername(user.getUsername()).isPresent()) {
            // Registration successful, save user
            userService.saveUser(user);
            model.addAttribute("successMessage", "The user has been registered successfully");
        }else{
            model.addAttribute("unsuccessMessage", "This username has already been registered");
        }
        return "registration";
    }

}