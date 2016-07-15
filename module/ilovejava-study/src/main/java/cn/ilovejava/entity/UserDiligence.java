package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yqy on 2016/7/15.
 */
@Entity
@Table(name = "java_user_diligence", schema = "", catalog = "java")
public class UserDiligence extends BaseEntity {
    @Basic
    @Column(name = "diligence_")
    private int diligence;
    @Basic
    @Column(name = "readcount_")
    private int readcount;

    public int getDiligence() {
        return diligence;
    }

    public void setDiligence(int diligence) {
        this.diligence = diligence;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }
}
