package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;

import java.util.Optional;

public interface ArticleService {

    //add new article
    void saveArticle(Article article);

    Optional<Article> findByAid(Integer Aid);

    Optional<Article> findByPostBy(User user);

    //Optional<Article> findAllOrderByAid();

    void delete(Article article);
}
