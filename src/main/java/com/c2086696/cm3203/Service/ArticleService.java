package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;

import java.util.List;

public interface ArticleService {
    //save the article
    void saveArticle(Article article);
    //find the article by the article ID
    Article findByAid(Integer aid);
    //find the article by the poster
    List<Article> findByName(User user);
    //delete the article by the article ID
    void deleteByAid(Integer aid);
    //find all articles
    List<Article> findAll();
}
