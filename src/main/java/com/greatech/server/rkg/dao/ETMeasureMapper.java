package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.ETMeasure;
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

import static com.greatech.server.rkg.dao.ETMeasureDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ETMeasureMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ETMeasure>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, content, createTime, uodateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ETMeasureResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uodate_by", property="uodateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ETMeasure> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ETMeasureResult")
    Optional<ETMeasure> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ETMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ETMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ETMeasure row) {
        return MyBatis3Utils.insert(this::insert, row, ETMeasure, c ->
            c.map(id).toProperty("id")
            .map(content).toProperty("content")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ETMeasure> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ETMeasure, c ->
            c.map(id).toProperty("id")
            .map(content).toProperty("content")
            .map(createTime).toProperty("createTime")
            .map(uodateBy).toProperty("uodateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ETMeasure row) {
        return MyBatis3Utils.insert(this::insert, row, ETMeasure, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(content).toPropertyWhenPresent("content", row::getContent)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(uodateBy).toPropertyWhenPresent("uodateBy", row::getUodateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETMeasure> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ETMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETMeasure> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ETMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETMeasure> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ETMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETMeasure> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ETMeasure, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ETMeasure row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(content).equalTo(row::getContent)
                .set(createTime).equalTo(row::getCreateTime)
                .set(uodateBy).equalTo(row::getUodateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ETMeasure row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(content).equalToWhenPresent(row::getContent)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(uodateBy).equalToWhenPresent(row::getUodateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ETMeasure row) {
        return update(c ->
            c.set(content).equalTo(row::getContent)
            .set(createTime).equalTo(row::getCreateTime)
            .set(uodateBy).equalTo(row::getUodateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ETMeasure row) {
        return update(c ->
            c.set(content).equalToWhenPresent(row::getContent)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(uodateBy).equalToWhenPresent(row::getUodateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}