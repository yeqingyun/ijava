package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;

import javax.persistence.*;

/**
 * Created by yqy on 2016/6/30.
 */
@Entity
@Table(name = "java_content", schema = "", catalog = "java")
public class ArticleContent extends BaseEntity {
    @Basic
    @Column(name = "contenttext_")
    private String contentText;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @OneToOne
    @JoinColumn(name = "artcileid_")//, referencedColumnName = "id_"
    private Article artcile;


    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleContent that = (ArticleContent) o;

        if (contentText != null ? !contentText.equals(that.contentText) : that.contentText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return contentText != null ? contentText.hashCode() : 0;
    }

    public Article getArtcile() {
        return artcile;
    }

    public void setArtcile(Article artcile) {
        this.artcile = artcile;
    }
}
