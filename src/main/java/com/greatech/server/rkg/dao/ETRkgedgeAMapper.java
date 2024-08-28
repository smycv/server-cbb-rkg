package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.ETRkgedgeA;
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

import static com.greatech.server.rkg.dao.ETRkgedgeADynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ETRkgedgeAMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ETRkgedgeA>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, source, target, createTime, updateBy, updateTime, style);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ETRkgedgeAResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="style", property="style", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ETRkgedgeA> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ETRkgedgeAResult")
    Optional<ETRkgedgeA> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ETRkgedgeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ETRkgedgeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ETRkgedgeA row) {
        return MyBatis3Utils.insert(this::insert, row, ETRkgedgeA, c ->
            c.map(id).toProperty("id")
            .map(source).toProperty("source")
            .map(target).toProperty("target")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(style).toProperty("style")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ETRkgedgeA> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ETRkgedgeA, c ->
            c.map(id).toProperty("id")
            .map(source).toProperty("source")
            .map(target).toProperty("target")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(style).toProperty("style")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ETRkgedgeA row) {
        return MyBatis3Utils.insert(this::insert, row, ETRkgedgeA, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(source).toPropertyWhenPresent("source", row::getSource)
            .map(target).toPropertyWhenPresent("target", row::getTarget)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(style).toPropertyWhenPresent("style", row::getStyle)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETRkgedgeA> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ETRkgedgeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETRkgedgeA> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ETRkgedgeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETRkgedgeA> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ETRkgedgeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETRkgedgeA> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ETRkgedgeA, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ETRkgedgeA row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(source).equalTo(row::getSource)
                .set(target).equalTo(row::getTarget)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(style).equalTo(row::getStyle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ETRkgedgeA row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(source).equalToWhenPresent(row::getSource)
                .set(target).equalToWhenPresent(row::getTarget)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(style).equalToWhenPresent(row::getStyle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ETRkgedgeA row) {
        return update(c ->
            c.set(source).equalTo(row::getSource)
            .set(target).equalTo(row::getTarget)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(style).equalTo(row::getStyle)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ETRkgedgeA row) {
        return update(c ->
            c.set(source).equalToWhenPresent(row::getSource)
            .set(target).equalToWhenPresent(row::getTarget)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(style).equalToWhenPresent(row::getStyle)
            .where(id, isEqualTo(row::getId))
        );
    }
}