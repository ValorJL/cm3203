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
import java.util.List;

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
        article.setUser(user);
        model.addAttribute("article", article);
        return "/newArticle";
    }


    @RequestMapping(value = "/newArticle", method = RequestMethod.POST)
    public String createNewArticle(@ModelAttribute("article") Article article) {
        articleService.saveArticle(article);
        return "redirect:/welcome";
    }


    @RequestMapping(value = "/article/{aid}", method = RequestMethod.GET)
    public String getArticleWithId(@PathVariable Integer aid,Model model) {
        Article a = articleService.findByAid(aid);
        model.addAttribute("article",a);
        model.addAttribute("newLineChar", '\n');
        return "/article";
    }

    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public String management(Model model, HttpServletRequest request){
        String str = (String) request.getSession().getAttribute("loginName");
        User user = userService.findByName(str).get();
        List<Article> articleList = articleService.findByName(user);
        model.addAttribute("articleList",articleList);
        return"/management";
    }

    @RequestMapping(value = "/deleteArticle/{aid}", method = RequestMethod.GET)
    public String deletePostWithId(@PathVariable Integer aid, HttpServletRequest request) {
        String str = (String) request.getSession().getAttribute("loginName");
        User user = userService.findByName(str).get();
        if(articleService.findByAid(aid).getUser().equals(user)){
            articleService.deleteByAid(aid);
            return "redirect:/management";
        }
        return null;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String allArticle(Model model){
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articleList",articleList);
        return"/welcome";
    }

}
