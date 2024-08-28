package com.greatech.server.rkg.dao;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class ETRkgnodeADynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ETRkgnodeA ETRkgnodeA = new ETRkgnodeA();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ETRkgnodeA.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nodeClass = ETRkgnodeA.nodeClass;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> type = ETRkgnodeA.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = ETRkgnodeA.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = ETRkgnodeA.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = ETRkgnodeA.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> data = ETRkgnodeA.data;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> style = ETRkgnodeA.style;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ETRkgnodeA extends AliasableSqlTable<ETRkgnodeA> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> nodeClass = column("node_class", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("update_by", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> data = column("data", JDBCType.LONGVARCHAR);

        public final SqlColumn<String> style = column("style", JDBCType.LONGVARCHAR);

        public ETRkgnodeA() {
            super("e_t_rkgnode_a", ETRkgnodeA::new);
        }
    }
}