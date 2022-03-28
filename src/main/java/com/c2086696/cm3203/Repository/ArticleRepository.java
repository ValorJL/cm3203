package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    List<Article> findByAid(Integer aid);

    List<Article> findByPostBy(User user);

    List<Article> findAll();

    void  deleteByAid(Integer aid);
}
