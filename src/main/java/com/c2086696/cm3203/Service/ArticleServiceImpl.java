package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.Article;
import com.c2086696.cm3203.DAO.User;
import com.c2086696.cm3203.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    //save the new article
    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    //find article by article ID
    @Override
    public Optional<Article> findByAid(Long aid) {
        return articleRepository.findByAid(aid);
    }

    //find article by article's poster
    @Override
    public List<Article> findByUser(User user) {
        return articleRepository.findByUser(user);
    }

    //find all articles
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    //delete article by article ID
    @Override
    public void deleteByAid(Long aid) {

        articleRepository.deleteByAid(aid);
    }
}
