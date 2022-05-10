package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.Article;
import com.c2086696.cm3203.Entity.User;
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

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Optional<Article> findByAid(Long aid) {
        return articleRepository.findByAid(aid);
    }

    @Override
    public List<Article> findByUser(User user) {
        return articleRepository.findByUser(user);
    }

    @Override
    public void deleteByAid(Long aid) {

        articleRepository.deleteByAid(aid);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
