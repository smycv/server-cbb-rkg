package com.greatech.server.rkg.pojo;

import jakarta.annotation.Generated;

import java.io.Serializable;
import java.util.Date;

public class RTReasonEvent implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long reasonId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long eventId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long uodateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getReasonId() {
        return reasonId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getEventId() {
        return eventId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUodateBy() {
        return uodateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUodateBy(Long uodateBy) {
        this.uodateBy = uodateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reasonId=").append(reasonId);
        sb.append(", eventId=").append(eventId);
        sb.append(", createTime=").append(createTime);
        sb.append(", uodateBy=").append(uodateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}