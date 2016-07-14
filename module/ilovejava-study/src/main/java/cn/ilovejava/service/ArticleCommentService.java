package cn.ilovejava.service;

import cn.ilovejava.baseBean.BaseRepository;
import cn.ilovejava.baseBean.BaseService;
import cn.ilovejava.dao.ArticleCommentRepository;
import cn.ilovejava.entity.ArticleComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by yeqy on 2016-07-13 16:35:11.
*/
@Service
@Transactional
public class ArticleCommentService<T extends ArticleComment> extends BaseService<ArticleComment>{

    @Resource
    private ArticleCommentRepository<ArticleComment> articleCommentRepository;

    @Override
    public BaseRepository<ArticleComment> getBaseRepository() {return articleCommentRepository;}

    public List<ArticleComment> findArticleCommentByArticleIdOrderByDate(Long id){
        return articleCommentRepository.findByArticleIdOrderByPublishTimeDesc(id);
    }

    public Page<ArticleComment> findByArticleIdOrderByPublishTimeDesc(Long id,Pageable pageable){
        return articleCommentRepository.findByArticleIdOrderByPublishTimeDesc(id,pageable);
    }
}