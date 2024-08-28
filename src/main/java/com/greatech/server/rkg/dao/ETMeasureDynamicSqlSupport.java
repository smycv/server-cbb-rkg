package com.greatech.server.rkg.dao;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class ETMeasureDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ETMeasure ETMeasure = new ETMeasure();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ETMeasure.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> content = ETMeasure.content;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = ETMeasure.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = ETMeasure.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = ETMeasure.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ETMeasure extends AliasableSqlTable<ETMeasure> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> content = column("content", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("update_by", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public ETMeasure() {
            super("e_t_measure", ETMeasure::new);
        }
    }
}