package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* Created by yeqy on 2016-06-30 15:15:35.
*/
public interface ArticleRepository<T extends Article> extends BaseRepository<Article> {
    @Query("select a from Article a order by viewCount desc,publishTime desc")
    public Page<Article> findOrderByPublishTimeDesc(Pageable pageable);

    @Query("select a from Article a where a.moduleCode =:moduleCode order by viewCount desc,publishTime desc")
    public Page<Article> findByModuleCodeOrderByPublishTimeDesc(@Param("moduleCode")String moduleCode,Pageable pageable);

}