package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    //add new article
    void saveArticle(Article article);

    Article findByAid(Integer aid);

    List<Article> findByUser(User user);

    void deleteByAid(Integer aid);

    List<Article> findAll();
}
