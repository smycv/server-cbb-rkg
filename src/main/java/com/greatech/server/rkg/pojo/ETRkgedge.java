package com.greatech.server.rkg.pojo;

import jakarta.annotation.Generated;

import java.io.Serializable;
import java.util.Date;

public class ETRkgedge implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long source;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long target;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tag;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long updateBy;

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
    public Long getSource() {
        return source;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSource(Long source) {
        this.source = source;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getTarget() {
        return target;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTarget(Long target) {
        this.target = target;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTag() {
        return tag;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTag(String tag) {
        this.tag = tag;
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
    public Long getUpdateBy() {
        return updateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
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
        sb.append(", source=").append(source);
        sb.append(", target=").append(target);
        sb.append(", tag=").append(tag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}