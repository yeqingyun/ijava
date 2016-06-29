package cn.ilovejava.entity;

import cn.ilovejava.baseBean.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by NF on 2016/6/26.
 */
@Entity
@Table(name = "java_module", schema = "", catalog = "java")
public class Module extends BaseEntity {
    private String code;
    private String name;
    private String parentcode;
    private String url;

    @Basic
    @Column(name = "code_")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name_")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parentcode_")
    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    @Basic
    @Column(name = "url_")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (code != null ? !code.equals(module.code) : module.code != null) return false;
        if (name != null ? !name.equals(module.name) : module.name != null) return false;
        if (parentcode != null ? !parentcode.equals(module.parentcode) : module.parentcode != null) return false;
        if (url != null ? !url.equals(module.url) : module.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentcode != null ? parentcode.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
