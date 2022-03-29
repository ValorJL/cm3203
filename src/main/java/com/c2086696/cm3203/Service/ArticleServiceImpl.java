package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Optional <Article> findByAid(Integer Aid) {
        return articleRepository.findByAid(Aid);
    }

    @Override
    public Optional <Article> findByPostBy(User user) {
        return articleRepository.findByPostBy(user);
    }

    //@Override
    //public Optional <Article> findAllOrderByAid() {
    //    return articleRepository.findAllOrderByAid();
    //}

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
