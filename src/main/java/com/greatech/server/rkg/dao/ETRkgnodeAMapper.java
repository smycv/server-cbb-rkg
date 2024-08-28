package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.ETRkgnodeA;
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

import static com.greatech.server.rkg.dao.ETRkgnodeADynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ETRkgnodeAMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ETRkgnodeA>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, nodeClass, type, createTime, updateBy, updateTime, data, style);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ETRkgnodeAResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="node_class", property="nodeClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="style", property="style", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ETRkgnodeA> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ETRkgnodeAResult")
    Optional<ETRkgnodeA> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ETRkgnodeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ETRkgnodeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ETRkgnodeA row) {
        return MyBatis3Utils.insert(this::insert, row, ETRkgnodeA, c ->
            c.map(id).toProperty("id")
            .map(nodeClass).toProperty("nodeClass")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(data).toProperty("data")
            .map(style).toProperty("style")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ETRkgnodeA> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ETRkgnodeA, c ->
            c.map(id).toProperty("id")
            .map(nodeClass).toProperty("nodeClass")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(data).toProperty("data")
            .map(style).toProperty("style")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ETRkgnodeA row) {
        return MyBatis3Utils.insert(this::insert, row, ETRkgnodeA, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(nodeClass).toPropertyWhenPresent("nodeClass", row::getNodeClass)
            .map(type).toPropertyWhenPresent("type", row::getType)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(data).toPropertyWhenPresent("data", row::getData)
            .map(style).toPropertyWhenPresent("style", row::getStyle)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETRkgnodeA> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ETRkgnodeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETRkgnodeA> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ETRkgnodeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETRkgnodeA> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ETRkgnodeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETRkgnodeA> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ETRkgnodeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ETRkgnodeA row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(nodeClass).equalTo(row::getNodeClass)
                .set(type).equalTo(row::getType)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(data).equalTo(row::getData)
                .set(style).equalTo(row::getStyle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ETRkgnodeA row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(nodeClass).equalToWhenPresent(row::getNodeClass)
                .set(type).equalToWhenPresent(row::getType)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(data).equalToWhenPresent(row::getData)
                .set(style).equalToWhenPresent(row::getStyle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ETRkgnodeA row) {
        return update(c ->
            c.set(nodeClass).equalTo(row::getNodeClass)
            .set(type).equalTo(row::getType)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(data).equalTo(row::getData)
            .set(style).equalTo(row::getStyle)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ETRkgnodeA row) {
        return update(c ->
            c.set(nodeClass).equalToWhenPresent(row::getNodeClass)
            .set(type).equalToWhenPresent(row::getType)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(data).equalToWhenPresent(row::getData)
            .set(style).equalToWhenPresent(row::getStyle)
            .where(id, isEqualTo(row::getId))
        );
    }
}