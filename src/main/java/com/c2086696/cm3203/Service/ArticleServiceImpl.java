package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;
import com.c2086696.cm3203.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    //save the article
    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }
    //find the article by the article ID
    @Override
    public Article findByAid(Integer aid) {
        return articleRepository.findByAid(aid);
    }
    //find the article by the poster
    @Override
    public List<Article> findByName(User user) {
        return articleRepository.findByName(user);
    }
    //delete the article by the article ID
    @Override
    public void deleteByAid(Integer aid) {
        articleRepository.deleteByAid(aid);
    }
    //find all articles
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
