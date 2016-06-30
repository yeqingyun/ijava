package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.ArticleRepository;
import cn.ilovejava.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
@Service
@Transactional
public class ArticleService<T extends Article> extends BaseService<Article>{

    @Resource
    private ArticleRepository<Article> articleRepository;

    @Override
    public BaseRepository<Article> getBaseRepository() {return articleRepository;}
}