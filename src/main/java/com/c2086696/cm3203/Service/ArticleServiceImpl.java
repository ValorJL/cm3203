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

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article findByAid(Integer aid) {
        return articleRepository.findByAid(aid);
    }

    @Override
    public List<Article> findByName(User user) {
        return articleRepository.findByName(user);
    }


    @Override
    public void deleteByAid(Integer aid) {

        articleRepository.deleteByAid(aid);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
