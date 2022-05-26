package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    //Find the article by article ID
    Article findByAid(Integer aid);
    //Find the articles by poster's name
    List<Article> findByName(User user);
    //Find all articles
    List<Article> findAll();
    //Delete the article by article ID
    void deleteByAid(Integer aid);
}
