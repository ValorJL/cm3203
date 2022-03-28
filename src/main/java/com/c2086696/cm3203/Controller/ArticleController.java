package com.c2086696.cm3203.Controller;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Article> getAllArticle() {
        // This returns a JSON or XML with the users
        return articleRepository.findAll();
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String title
            , @RequestParam String content) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Article a = new Article();
        a.setTitle(title);
        a.setContent(content);
        articleRepository.save(a);
        return "Saved";
    }
}
