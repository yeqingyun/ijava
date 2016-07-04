package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yqy on 2016/6/30.
 */
@Entity
@Table(name = "java_article", schema = "", catalog = "java")
public class Article extends BaseEntity {
    @Basic
    @Column(name = "title_")
    private String title;
    @Basic
    @Column(name = "modulecode_")
    private int moduleCode;
    @Basic
    @Column(name = "authorid_")
    private int author;
    @Basic
    @Column(name = "typeid_")
    private int typeId;
    @OneToOne
    @JoinColumn(name = "contentid_")
    private ArticleContent content;
    @Basic
    @Column(name = "subtitle_")
    private String subtitle;
    @Basic
    @Column(name = "viewcount_")
    private long viewCount;
    @Basic
    @Column(name = "publishtime_")
    @Temporal(TemporalType.DATE)
    private Date publishTime;
    @Basic
    @Column(name = "like_")
    private long like;
    @Basic
    @Column(name = "dislike_")
    private long dislike;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(int moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    public String getSubtitle() {
        return subtitle;
    }

    public ArticleContent getContent() {
        return content;
    }

    public void setContent(ArticleContent content) {
        this.content = content;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public long getLike() {
        return like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    public long getDislike() {
        return dislike;
    }

    public void setDislike(long dislike) {
        this.dislike = dislike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article that = (Article) o;

        if (moduleCode != that.moduleCode) return false;
        if (author != that.author) return false;
        if (typeId != that.typeId) return false;
        //if (contentId != that.contentId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (subtitle != null ? !subtitle.equals(that.subtitle) : that.subtitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + moduleCode;
        result = 31 * result + author;
        result = 31 * result + typeId;
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        return result;
    }
}
