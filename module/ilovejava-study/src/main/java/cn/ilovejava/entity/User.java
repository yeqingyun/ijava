package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yqy on 2016/7/15.
 */
@Entity
@Table(name = "java_user", schema = "", catalog = "java")
public class User extends BaseEntity {
    @Basic
    @Column(name = "name_")
    private String name;
    @Basic
    @Column(name = "code_")
    private String code;
    @Basic
    @Column(name = "type_")
    private String type;
    @Basic
    @Column(name = "email_")
    private String email;
    @Basic
    @Column(name = "phone_")
    private String phone;
    @JSONField(format="yyyy-MM-dd")
    @Basic
    @Column(name = "registertime_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;
    @OneToOne
    @JoinColumn(name = "diligenceid_")
    private UserDiligence diligence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
