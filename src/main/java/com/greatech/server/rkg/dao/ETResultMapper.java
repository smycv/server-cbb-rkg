package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.ETResult;
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

import static com.greatech.server.rkg.dao.ETResultDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ETResultMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ETResult>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, content, createTime, updateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ETResultResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ETResult> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ETResultResult")
    Optional<ETResult> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ETResult, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ETResult, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ETResult row) {
        return MyBatis3Utils.insert(this::insert, row, ETResult, c ->
            c.map(id).toProperty("id")
            .map(content).toProperty("content")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ETResult> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ETResult, c ->
            c.map(id).toProperty("id")
            .map(content).toProperty("content")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ETResult row) {
        return MyBatis3Utils.insert(this::insert, row, ETResult, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(content).toPropertyWhenPresent("content", row::getContent)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETResult> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ETResult, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETResult> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ETResult, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETResult> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ETResult, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETResult> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ETResult, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ETResult row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(content).equalTo(row::getContent)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ETResult row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(content).equalToWhenPresent(row::getContent)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ETResult row) {
        return update(c ->
            c.set(content).equalTo(row::getContent)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ETResult row) {
        return update(c ->
            c.set(content).equalToWhenPresent(row::getContent)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}