package com.scdkay.website.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 产品实体类
 * Created by liurui on 2017/7/12.
 */
@Entity
@Table(name = "production")
public class ProductionEntity {
    private int id;
    private int categoryId;
    private String nameCn;
    private String nameEn;
    private String content;
    private Timestamp publishTime;
    private String details;
    private int status;
    private String introduction;
    private List<FileEntity> fileEntities;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name_cn")
    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    @Basic
    @Column(name = "name_en")
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @OneToMany
    @JoinColumn(name = "linked_id")
    public List<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(List<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionEntity that = (ProductionEntity) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (status != that.status) return false;
        if (nameCn != null ? !nameCn.equals(that.nameCn) : that.nameCn != null) return false;
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;
        return fileEntities != null ? fileEntities.equals(that.fileEntities) : that.fileEntities == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + categoryId;
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (fileEntities != null ? fileEntities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductionEntity{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", nameCn='" + nameCn + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", details='" + details + '\'' +
                ", status=" + status +
                ", introduction='" + introduction + '\'' +
                ", fileEntities=" + fileEntities +
                '}';
    }
}
