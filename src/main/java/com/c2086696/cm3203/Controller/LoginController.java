package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@Controller
public class LoginController {
    //方法6，成功，采用
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "/login";
    }

    @PostMapping("/loginVerify")
    public String loginVerify(String username,String password,HttpSession session){
        User user = new User();
        user.setName(username);
        user.setPassword(password);

        boolean verify = userService.verifyLogin(user);
        if (verify) {
            session.setAttribute("loginUser", username);
            return "redirect:/welcome";
        } else {
            return "redirect:/login";
        }
    }


//    //方法4
//    private final UserService userService;
//
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        return "/login";
//    }
//
//    //@RequestMapping(value = "/login",method = RequestMethod.POST)
//    @PostMapping(value = "/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Map<String,Object> map, HttpSession session){
//        //成功了呀，这个进去了，但是我不能密码总是123哇，所以这个方法4也先放一放
//        if(!StringUtils.isEmpty(username) && "123".equals(password)){
//            //登陆成功，防止表单重复提交，可以重定向到主页
//            session.setAttribute("loginUser",username);
//            return "redirect:/welcome.html";
//            //return "/welcome";
//        }else{
//            //登陆失败
//
//            map.put("msg","用户名密码错误");
//            return  "login";
//        }
//
//    }

    //方法5(还没整完）https://blog.csdn.net/u010253246/article/details/112681371
    //检查该用户名是否存在
//    String res = userService.check_name(name);
//        if (!res.equals("registed")) {
//        return "userName has not registed";
//    }
//    //检查密码是否正确
//    String str = userService.check_name_and_password(name, password);
//        if (str.equals("success")){
//        //第一步：获取session
//        HttpSession session = request.getSession();
//        //第二步：将想要保存到数据存入session中
//        session.setAttribute("name",name);
//        session.setAttribute("password",password);
//        //这样就完成了用户名和密码保存到session的操作
//    }


//    //第三版了
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        return "/login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String toWelcome(Principal principal) {
//        //TODO：还是Null，再想其他办法吧
//        if (principal != null) {
//            return "redirect:/welcome";
//        }
//        //return "/login";
//        return "test01";
//    }

//    //第二版
//    @GetMapping("/login")
//    public String login(Principal principal) {
//
//        if (principal != null) {
//            return "redirect:/welcome";
//        }
//        return "/login";
//    }


//第一版
//    private final UserService userService;
//
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        return "/login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String toWelcomePage(@ModelAttribute("user") User user) {
//        //现在是可以去首页，但完全没经过身份验证
//        //如果用户名不存在，报错
//        //If this name doesn't exist, return null
//        //TODO：这里的If条件一直显示null
////        if (userService.findByName(user.getName()).isEmpty()) {
////            return null;
////        }
//
//        User tem = new User();
//        tem.setPassword(userService.findByName(user.getName()).get().getPassword());
//        if(tem.getPassword().equals(user.getPassword())){
//            return "redirect:/welcome";
//        }
//        //如果这个用户名查出来的密码和用户提交上来的密码相同
//        //return "redirect:/welcome";
//        return "/login";
//    }
}
