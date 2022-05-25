package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

    Optional<Article> findByAid(Long aid);

    List<Article> findByUser(User user);

    List<Article> findAll();

    void deleteByAid(Long aid);
}
