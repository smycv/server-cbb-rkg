package com.greatech.server.rkg.dao;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class RTReasonEventDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RTReasonEvent RTReasonEvent = new RTReasonEvent();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = RTReasonEvent.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> reasonId = RTReasonEvent.reasonId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> eventId = RTReasonEvent.eventId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = RTReasonEvent.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> uodateBy = RTReasonEvent.uodateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = RTReasonEvent.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RTReasonEvent extends AliasableSqlTable<RTReasonEvent> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> reasonId = column("reason_id", JDBCType.BIGINT);

        public final SqlColumn<Long> eventId = column("event_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> uodateBy = column("uodate_by", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public RTReasonEvent() {
            super("r_t_reason_event", RTReasonEvent::new);
        }
    }
}