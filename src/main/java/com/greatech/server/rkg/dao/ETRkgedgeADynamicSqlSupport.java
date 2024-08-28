package com.greatech.server.rkg.dao;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class ETRkgedgeADynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ETRkgedgeA ETRkgedgeA = new ETRkgedgeA();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ETRkgedgeA.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> source = ETRkgedgeA.source;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> target = ETRkgedgeA.target;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = ETRkgedgeA.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = ETRkgedgeA.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = ETRkgedgeA.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> style = ETRkgedgeA.style;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ETRkgedgeA extends AliasableSqlTable<ETRkgedgeA> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> source = column("source", JDBCType.VARCHAR);

        public final SqlColumn<String> target = column("target", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("update_by", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> style = column("style", JDBCType.LONGVARCHAR);

        public ETRkgedgeA() {
            super("e_t_rkgedge_a", ETRkgedgeA::new);
        }
    }
}