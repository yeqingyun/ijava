package cn.ilovejava.dao;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.entity.ArticleComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
* Created by yeqy on 2016-07-13 16:35:11.
*/
public interface ArticleCommentRepository<T extends ArticleComment> extends BaseRepository<ArticleComment> {

    public List<ArticleComment> findByArticleIdOrderByPublishTimeDesc(Long id);

    public Page<ArticleComment> findByArticleIdOrderByPublishTimeDesc(Long id,Pageable pageable);
}