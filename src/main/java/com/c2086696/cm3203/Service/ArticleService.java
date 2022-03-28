package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;

import java.util.List;

public interface ArticleService {

    //add new article
    void saveArticle(Article article);

    List<Article> findByAid(Integer Aid);

    List<Article> findByPostBy(User user);

    List<Article> findAll();

    void deleteByAid(Integer Aid);
}
