package com.scdkay.website.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 图片实体类
 * Created by liurui on 2017/7/19.
 */
@Entity
@Table(name = "file")
public class FileEntity {
    private int id;
    private int type;
    private int linkedId;
    private String url;
    private Timestamp uploadTime;
    private String details;
    private Integer uploadType;
    private int status;
    private int isCover;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "linked_id")
    public int getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(int linkedId) {
        this.linkedId = linkedId;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "upload_time")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
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
    @Column(name = "upload_type")
    public Integer getUploadType() {
        return uploadType;
    }

    public void setUploadType(Integer uploadType) {
        this.uploadType = uploadType;
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
    @Column(name = "is_cover")
    public int getIsCover() {
        return isCover;
    }

    public void setIsCover(int isCover) {
        this.isCover = isCover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEntity that = (FileEntity) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (linkedId != that.linkedId) return false;
        if (status != that.status) return false;
        if (isCover != that.isCover) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (uploadType != null ? !uploadType.equals(that.uploadType) : that.uploadType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type;
        result = 31 * result + linkedId;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (uploadType != null ? uploadType.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + isCover;
        return result;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", type=" + type +
                ", linkedId=" + linkedId +
                ", url='" + url + '\'' +
                ", uploadTime=" + uploadTime +
                ", details='" + details + '\'' +
                ", uploadType=" + uploadType +
                ", status=" + status +
                ", isCover=" + isCover +
                '}';
    }
}
