package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Service.ArticleService;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final UserService userService;

    @Autowired
    public ArticleController(ArticleService articleService, UserService userService) {
        this.articleService = articleService;
        this.userService = userService;
    }


    @RequestMapping(value = "/newArticle", method = RequestMethod.GET)
    public String newArticle(Principal principal, Model model) {
        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent()) {
            Article article = new Article();
            article.setUser(user.get());
            model.addAttribute("article", article);
            return "newArticle";

        } else {
            return null;
        }
    }

    @RequestMapping(value = "/newArticle", method = RequestMethod.POST)
    public String createNewPost(Article article,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "newArticle";
        } else {
            articleService.saveArticle(article);
            return "redirect:/welcome";
        }
    }

    @RequestMapping(value = "/article/{aid}", method = RequestMethod.GET)
    public String getArticleWithAid(@PathVariable Long aid,
                                Principal principal,
                                Model model) {

        Optional<Article> optionalArticle = articleService.findByAid(aid);

        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            model.addAttribute("article",article);
            model.addAttribute("username", principal.getName());
            model.addAttribute("newLineChar", '\n');
            return "article";

        } else {
            return null;
        }

    }

    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public String management(Principal principal, Model model){

        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent()) {
            List<Article> articleList = articleService.findByUser(user.get());
            model.addAttribute("articleList",articleList);
            return"management";

        } else {
            return null;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteWithAid(String aid, Principal principal) {
        long aidLong = Long.parseLong(aid);
        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent() && articleService.findByAid(aidLong).get().getUser().equals(user.get())) {
            articleService.deleteByAid(aidLong);
            return "redirect:/welcome";

        } else {
            return null;
        }
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String allArticle(Model model){
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articleList",articleList);
        return "welcome";
    }

}
