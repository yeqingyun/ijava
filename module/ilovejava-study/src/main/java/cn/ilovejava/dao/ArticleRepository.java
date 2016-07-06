package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
public interface ArticleRepository<T extends Article> extends BaseRepository<Article> {
    @Query("select a from Article a order by publishTime,viewCount desc")
    public Page<Article> findOrderByPublishTimeDesc(Pageable pageable);
}