package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.Article;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
public interface ArticleRepository<T extends Article> extends BaseRepository<Article> {

}