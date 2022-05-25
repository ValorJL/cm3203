package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;

import java.util.List;

public interface ArticleService {

    //add new article
    void saveArticle(Article article);

    Article findByAid(Integer aid);

    List<Article> findByName(User user);

    //List<Article> findAllOrderByAid();

    void deleteByAid(Integer aid);

    List<Article> findAll();
}
