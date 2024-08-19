package com.greatech.server.rkg.pojo;

import jakarta.annotation.Generated;

import java.io.Serializable;
import java.util.Date;

public class ETRkgnode implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long objId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String obj;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String color;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String type;

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
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getObjId() {
        return objId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getObj() {
        return obj;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setObj(String obj) {
        this.obj = obj;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getColor() {
        return color;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setColor(String color) {
        this.color = color;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getType() {
        return type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setType(String type) {
        this.type = type;
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
        sb.append(", name=").append(name);
        sb.append(", objId=").append(objId);
        sb.append(", obj=").append(obj);
        sb.append(", color=").append(color);
        sb.append(", type=").append(type);
        sb.append(", createTime=").append(createTime);
        sb.append(", uodateBy=").append(uodateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}