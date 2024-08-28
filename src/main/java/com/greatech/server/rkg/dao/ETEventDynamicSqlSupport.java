package com.greatech.server.rkg.dao;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class ETEventDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ETEvent ETEvent = new ETEvent();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = ETEvent.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> determine = ETEvent.determine;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = ETEvent.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = ETEvent.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = ETEvent.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ETEvent extends AliasableSqlTable<ETEvent> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> determine = column("determine", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("update_by", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public ETEvent() {
            super("e_t_event", ETEvent::new);
        }
    }
}