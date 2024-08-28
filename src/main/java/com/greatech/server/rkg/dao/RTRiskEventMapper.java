package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.RTRiskEvent;
import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.greatech.server.rkg.dao.RTRiskEventDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface RTRiskEventMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<RTRiskEvent>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, riskId, eventId, createTime, updateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RTRiskEventResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="risk_id", property="riskId", jdbcType=JdbcType.BIGINT),
        @Result(column="event_id", property="eventId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RTRiskEvent> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RTRiskEventResult")
    Optional<RTRiskEvent> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, RTRiskEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, RTRiskEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RTRiskEvent row) {
        return MyBatis3Utils.insert(this::insert, row, RTRiskEvent, c ->
            c.map(id).toProperty("id")
            .map(riskId).toProperty("riskId")
            .map(eventId).toProperty("eventId")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RTRiskEvent> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, RTRiskEvent, c ->
            c.map(id).toProperty("id")
            .map(riskId).toProperty("riskId")
            .map(eventId).toProperty("eventId")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RTRiskEvent row) {
        return MyBatis3Utils.insert(this::insert, row, RTRiskEvent, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(riskId).toPropertyWhenPresent("riskId", row::getRiskId)
            .map(eventId).toPropertyWhenPresent("eventId", row::getEventId)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTRiskEvent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, RTRiskEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTRiskEvent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, RTRiskEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTRiskEvent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, RTRiskEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTRiskEvent> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, RTRiskEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RTRiskEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(riskId).equalTo(row::getRiskId)
                .set(eventId).equalTo(row::getEventId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RTRiskEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(riskId).equalToWhenPresent(row::getRiskId)
                .set(eventId).equalToWhenPresent(row::getEventId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RTRiskEvent row) {
        return update(c ->
            c.set(riskId).equalTo(row::getRiskId)
            .set(eventId).equalTo(row::getEventId)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RTRiskEvent row) {
        return update(c ->
            c.set(riskId).equalToWhenPresent(row::getRiskId)
            .set(eventId).equalToWhenPresent(row::getEventId)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}