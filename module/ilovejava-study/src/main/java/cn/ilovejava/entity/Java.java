package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by NF on 2016/6/26.
 */
@Data
@Entity
public class Java extends BaseEntity {
    private String name;
}
