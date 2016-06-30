package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.ArticleContentRepository;
import cn.ilovejava.entity.ArticleContent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
@Service
@Transactional
public class ArticleContentService<T extends ArticleContent> extends BaseService<ArticleContent>{

    @Resource
    private ArticleContentRepository<ArticleContent> articleContentRepository;

    @Override
    public BaseRepository<ArticleContent> getBaseRepository() {return articleContentRepository;}
}