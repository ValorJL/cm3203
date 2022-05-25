package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    //add new article
    void saveArticle(Article article);

    Optional<Article> findByAid(Long aid);

    List<Article> findByUser(User user);

    void deleteByAid(Long aid);

    List<Article> findAll();
}
