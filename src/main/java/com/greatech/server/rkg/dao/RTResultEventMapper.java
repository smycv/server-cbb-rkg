package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.RTResultEvent;
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

import static com.greatech.server.rkg.dao.RTResultEventDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface RTResultEventMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<RTResultEvent>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, resultId, eventId, createTime, uodateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RTResultEventResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="result_id", property="resultId", jdbcType=JdbcType.BIGINT),
        @Result(column="event_id", property="eventId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uodate_by", property="uodateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RTResultEvent> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RTResultEventResult")
    Optional<RTResultEvent> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, RTResultEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, RTResultEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RTResultEvent row) {
        return MyBatis3Utils.insert(this::insert, row, RTResultEvent, c ->
            c.map(id).toProperty("id")
            .map(resultId).toProperty("resultId")
            .map(eventId).toProperty("eventId")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RTResultEvent> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, RTResultEvent, c ->
            c.map(id).toProperty("id")
            .map(resultId).toProperty("resultId")
            .map(eventId).toProperty("eventId")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RTResultEvent row) {
        return MyBatis3Utils.insert(this::insert, row, RTResultEvent, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(resultId).toPropertyWhenPresent("resultId", row::getResultId)
            .map(eventId).toPropertyWhenPresent("eventId", row::getEventId)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(uodateBy).toPropertyWhenPresent("uodateBy", row::getUodateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTResultEvent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, RTResultEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTResultEvent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, RTResultEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTResultEvent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, RTResultEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTResultEvent> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, RTResultEvent, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RTResultEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(resultId).equalTo(row::getResultId)
                .set(eventId).equalTo(row::getEventId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(uodateBy).equalTo(row::getUodateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RTResultEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(resultId).equalToWhenPresent(row::getResultId)
                .set(eventId).equalToWhenPresent(row::getEventId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(uodateBy).equalToWhenPresent(row::getUodateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RTResultEvent row) {
        return update(c ->
            c.set(resultId).equalTo(row::getResultId)
            .set(eventId).equalTo(row::getEventId)
            .set(createTime).equalTo(row::getCreateTime)
            .set(uodateBy).equalTo(row::getUodateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RTResultEvent row) {
        return update(c ->
            c.set(resultId).equalToWhenPresent(row::getResultId)
            .set(eventId).equalToWhenPresent(row::getEventId)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(uodateBy).equalToWhenPresent(row::getUodateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}