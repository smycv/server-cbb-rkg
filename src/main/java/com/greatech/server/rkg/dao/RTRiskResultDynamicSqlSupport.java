package com.greatech.server.rkg.dao;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.util.Date;

public final class RTRiskResultDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RTRiskResult RTRiskResult = new RTRiskResult();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = RTRiskResult.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> riskId = RTRiskResult.riskId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> resultId = RTRiskResult.resultId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = RTRiskResult.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = RTRiskResult.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = RTRiskResult.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RTRiskResult extends AliasableSqlTable<RTRiskResult> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> riskId = column("risk_id", JDBCType.BIGINT);

        public final SqlColumn<Long> resultId = column("result_id", JDBCType.BIGINT);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("update_by", JDBCType.BIGINT);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public RTRiskResult() {
            super("r_t_risk_result", RTRiskResult::new);
        }
    }
}