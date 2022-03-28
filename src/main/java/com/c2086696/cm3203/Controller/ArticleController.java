package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Service.ArticleService;
import com.c2086696.cm3203.Service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    private ArticleService articleService;

    @RequestMapping(value = "/new-article", method = RequestMethod.GET)
    public String newArticle(Model model) {

        model.addAttribute("article", new Article());
        return "/new-article";
    }

    @RequestMapping(value = "/new-article", method = RequestMethod.POST)
    public String createNewArticle(@ModelAttribute("article") Article article) {

        if (!articleService.findByAid(article.getAid()).isEmpty()) {
            return null;
        }
        articleService.saveArticle(article);
        return "redirect:/welcome";
    }
}
