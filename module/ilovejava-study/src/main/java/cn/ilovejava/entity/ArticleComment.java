package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yqy on 2016/7/13.
 */
@Entity
@Table(name = "java_article_comment", schema = "", catalog = "java")
public class ArticleComment extends BaseEntity {
    @Basic
    @Column(name = "name_")
    private String name;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="articleid_")
    private Article article;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="parentcommentid_")
    private ArticleComment parent;
    @Basic
    @Column(name = "istourist_")
    private boolean isTourist;
    @Basic
    @Column(name = "commenttext_")
    private String commentText;
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    @Basic
    @Column(name = "publishtime_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArticleComment getParent() {
        return parent;
    }

    public void setParent(ArticleComment parent) {
        this.parent = parent;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


    public boolean isTourist() {
        return isTourist;
    }

    public void setIsTourist(boolean isTourist) {
        this.isTourist = isTourist;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleComment that = (ArticleComment) o;

        if (isTourist != that.isTourist) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (commentText != null ? !commentText.equals(that.commentText) : that.commentText != null) return false;

        return true;
    }
    @PrePersist
    private void setpublishNow(){
        this.setPublishTime(new Date());
    }


}
