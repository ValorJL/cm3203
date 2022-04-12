package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Service.ArticleService;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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

    //For show the appearance of the page
    @RequestMapping(value = "/newArticle", method = RequestMethod.GET)
    public String newArticle(Model model, HttpServletRequest request) {
        String str = (String) request.getSession().getAttribute("loginName");
        User user = userService.findByName(str).get();
        Article article = new Article();
        article.setName(user);
        model.addAttribute("article", article);
        return "/newArticle";
    }


    @RequestMapping(value = "/newArticle", method = RequestMethod.POST)
    public String createNewArticle(@ModelAttribute("article") Article article) {
        articleService.saveArticle(article);
        return "redirect:/welcome";
    }


    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String getArticleWithId(@PathVariable Integer aid,
                                Principal principal,
                                Model model) {

        Optional<Article> optionalArticle = articleService.findByAid(aid);

        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            model.addAttribute("article", article);

            if (isPrincipalOwnerOfArticle(principal, article)) {
                model.addAttribute("name", principal.getName());
            }

            return "/article";

        } else {
            return "/error";
        }
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Integer aid,
                                   Principal principal) {

        Optional<Article> optionalArticle = articleService.findByAid(aid);

        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            if (isPrincipalOwnerOfArticle(principal, article)) {
                articleService.delete(article);
                return "redirect:/welcome";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

    private boolean isPrincipalOwnerOfArticle(Principal principal, Article article) {
        return principal != null && principal.getName().equals(article.getName().getName());
    }
}
