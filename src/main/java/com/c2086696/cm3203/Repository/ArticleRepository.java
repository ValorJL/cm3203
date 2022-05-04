package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

    Article findByAid(Integer aid);

    List<Article> findByUser(User user);

    List<Article> findAll();
    //List<Article> findAllOrderByAid();

    void deleteByAid(Integer aid);
}
