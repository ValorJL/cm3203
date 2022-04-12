package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

    Optional<Article> findByAid(Integer aid);

    Optional<Article> findByName(User user);

    //Optional<Article> findAllOrderByAid();

    @Override
    void delete(Article article);
}
