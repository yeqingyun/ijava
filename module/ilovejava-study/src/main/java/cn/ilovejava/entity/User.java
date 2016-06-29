package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by yqy on 2016/6/24.
 */
@Entity
@Data
@Table(name = "user")
public class User extends BaseEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "petid", referencedColumnName = "id")
    private Pet petId;

    public User() {}


}
