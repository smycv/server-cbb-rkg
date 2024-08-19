package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.RTReasonEvent;
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

import static com.greatech.server.rkg.dao.RTReasonEventDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface RTReasonEventMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<RTReasonEvent>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, reasonId, eventId, createTime, uodateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RTReasonEventResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="reason_id", property="reasonId", jdbcType=JdbcType.BIGINT),
        @Result(column="event_id", property="eventId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uodate_by", property="uodateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RTReasonEvent> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RTReasonEventResult")
    Optional<RTReasonEvent> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, RTReasonEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, RTReasonEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RTReasonEvent row) {
        return MyBatis3Utils.insert(this::insert, row, RTReasonEvent, c ->
            c.map(id).toProperty("id")
            .map(reasonId).toProperty("reasonId")
            .map(eventId).toProperty("eventId")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RTReasonEvent> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, RTReasonEvent, c ->
            c.map(id).toProperty("id")
            .map(reasonId).toProperty("reasonId")
            .map(eventId).toProperty("eventId")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RTReasonEvent row) {
        return MyBatis3Utils.insert(this::insert, row, RTReasonEvent, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(reasonId).toPropertyWhenPresent("reasonId", row::getReasonId)
            .map(eventId).toPropertyWhenPresent("eventId", row::getEventId)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(uodateBy).toPropertyWhenPresent("uodateBy", row::getUodateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTReasonEvent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, RTReasonEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTReasonEvent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, RTReasonEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTReasonEvent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, RTReasonEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTReasonEvent> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, RTReasonEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RTReasonEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(reasonId).equalTo(row::getReasonId)
                .set(eventId).equalTo(row::getEventId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(uodateBy).equalTo(row::getUodateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RTReasonEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(reasonId).equalToWhenPresent(row::getReasonId)
                .set(eventId).equalToWhenPresent(row::getEventId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(uodateBy).equalToWhenPresent(row::getUodateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RTReasonEvent row) {
        return update(c ->
            c.set(reasonId).equalTo(row::getReasonId)
            .set(eventId).equalTo(row::getEventId)
            .set(createTime).equalTo(row::getCreateTime)
            .set(uodateBy).equalTo(row::getUodateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RTReasonEvent row) {
        return update(c ->
            c.set(reasonId).equalToWhenPresent(row::getReasonId)
            .set(eventId).equalToWhenPresent(row::getEventId)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(uodateBy).equalToWhenPresent(row::getUodateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}