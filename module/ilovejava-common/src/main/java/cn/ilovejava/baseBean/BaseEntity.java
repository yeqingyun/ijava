package cn.ilovejava.baseBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *   基础实体类
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    protected Long id;

    @Column(name = "createtime_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "createby_")
    private int createdBy;

    @Column(name = "updatetime_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updateby_")
    private int updatedBy;

    @Column(name = "status_")
    private boolean status;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;

        BaseEntity other = (BaseEntity) object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + " [ID=" + id + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @PrePersist
    public void setTimeWhenCreate(){
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void setTimeWhenUpdate(){
        Date now = new Date();
        this.updatedAt = now;
    }

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

}
