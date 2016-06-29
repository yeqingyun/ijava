package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yqy on 2016/6/20.
 */
@Entity
@Data
@Table(name = "pet")
public class Pet extends BaseEntity {
    private String name;
    private String owner;
    private String species;
    private String sex;
    private Date birth;
    private Date death;

    @PrePersist
    public void Owner(){
        this.owner = "yeqy";
    }
}
