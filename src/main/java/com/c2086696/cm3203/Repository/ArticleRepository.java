package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    //find article by article ID
    Optional<Article> findByAid(Long aid);
    //find article by article's poster
    List<Article> findByUser(User user);
    //find all articles
    List<Article> findAll();
    //delete article by article ID
    void deleteByAid(Long aid);
}
