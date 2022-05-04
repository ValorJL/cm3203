package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.management.relation.RoleNotFoundException;

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
    public String createNewUser(User user,
                                BindingResult bindingResult,
                                Model model) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        if (!bindingResult.hasErrors()) {
            // Registration successful, save user
            // Set user role to USER and set it as active
            userService.saveUser(user);

            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }

        return "/registration";
    }

//    @PostMapping(value = "/register")
//    public String registerNewUser2(@ModelAttribute("user") User user) throws RoleNotFoundException {
//        System.out.println("NewUser");
//        userService.saveUser(user);
//        return "/";
//    }

//    @PostMapping(value = "/register")
//    public String registerNewUser(@ModelAttribute("user") User user, BindingResult bindingResult, SessionStatus sessionStatus) throws RoleNotFoundException {
//        System.out.println("NewUser");
//        //If this name exists, return null
//        if(userService.findByUsername(user.getUsername()).isPresent()){
//            bindingResult.rejectValue("username","error.username","Username already exists");
//            System.out.println("Username already exists");
//
//        }
//        if (bindingResult.hasErrors()){
//            System.out.println("New user did not validate");
//            return "registerForm";
//        }
//        this.userService.saveUser(user);
//        System.out.println("this.userService.saveUser(user)");
//        Authentication auth = new UsernamePasswordAuthenticationToken(user,user.getPassword(),user.getAuthorities());
//        System.out.println("AuthToken: "+ auth);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        System.out.println("SecurityContext Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        sessionStatus.setComplete();
//        return "redirect:/";
//    }
}