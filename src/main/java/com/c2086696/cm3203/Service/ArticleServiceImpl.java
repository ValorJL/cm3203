package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Repository.ArticleRepository;

import javax.annotation.Resource;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> findByAid(Integer Aid) {
        return articleRepository.findByAid(Aid);
    }

    @Override
    public List<Article> findByPostBy(User user) {
        return articleRepository.findByPostBy(user);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteByAid(Integer Aid) {
        articleRepository.deleteByAid(Aid);
    }
}
