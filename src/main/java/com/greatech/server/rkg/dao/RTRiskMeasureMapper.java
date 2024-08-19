package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.RTRiskMeasure;
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

import static com.greatech.server.rkg.dao.RTRiskMeasureDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface RTRiskMeasureMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<RTRiskMeasure>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, riskId, measureId, createTime, uodateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RTRiskMeasureResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="risk_id", property="riskId", jdbcType=JdbcType.BIGINT),
        @Result(column="measure_id", property="measureId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uodate_by", property="uodateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RTRiskMeasure> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RTRiskMeasureResult")
    Optional<RTRiskMeasure> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, RTRiskMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, RTRiskMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RTRiskMeasure row) {
        return MyBatis3Utils.insert(this::insert, row, RTRiskMeasure, c ->
            c.map(id).toProperty("id")
            .map(riskId).toProperty("riskId")
            .map(measureId).toProperty("measureId")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RTRiskMeasure> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, RTRiskMeasure, c ->
            c.map(id).toProperty("id")
            .map(riskId).toProperty("riskId")
            .map(measureId).toProperty("measureId")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RTRiskMeasure row) {
        return MyBatis3Utils.insert(this::insert, row, RTRiskMeasure, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(riskId).toPropertyWhenPresent("riskId", row::getRiskId)
            .map(measureId).toPropertyWhenPresent("measureId", row::getMeasureId)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(uodateBy).toPropertyWhenPresent("uodateBy", row::getUodateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTRiskMeasure> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, RTRiskMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTRiskMeasure> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, RTRiskMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RTRiskMeasure> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, RTRiskMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RTRiskMeasure> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, RTRiskMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RTRiskMeasure row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(riskId).equalTo(row::getRiskId)
                .set(measureId).equalTo(row::getMeasureId)
                .set(createTime).equalTo(row::getCreateTime)
                .set(uodateBy).equalTo(row::getUodateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RTRiskMeasure row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(riskId).equalToWhenPresent(row::getRiskId)
                .set(measureId).equalToWhenPresent(row::getMeasureId)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(uodateBy).equalToWhenPresent(row::getUodateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RTRiskMeasure row) {
        return update(c ->
            c.set(riskId).equalTo(row::getRiskId)
            .set(measureId).equalTo(row::getMeasureId)
            .set(createTime).equalTo(row::getCreateTime)
            .set(uodateBy).equalTo(row::getUodateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RTRiskMeasure row) {
        return update(c ->
            c.set(riskId).equalToWhenPresent(row::getRiskId)
            .set(measureId).equalToWhenPresent(row::getMeasureId)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(uodateBy).equalToWhenPresent(row::getUodateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}