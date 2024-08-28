package com.greatech.server.rkg.dao;

import com.greatech.server.rkg.pojo.ETRkgnode;
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

import static com.greatech.server.rkg.dao.ETRkgnodeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ETRkgnodeMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ETRkgnode>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, objId, obj, color, type, createTime, updateBy, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ETRkgnodeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="obj_id", property="objId", jdbcType=JdbcType.BIGINT),
        @Result(column="obj", property="obj", jdbcType=JdbcType.VARCHAR),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ETRkgnode> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ETRkgnodeResult")
    Optional<ETRkgnode> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ETRkgnode, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ETRkgnode, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ETRkgnode row) {
        return MyBatis3Utils.insert(this::insert, row, ETRkgnode, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(objId).toProperty("objId")
            .map(obj).toProperty("obj")
            .map(color).toProperty("color")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ETRkgnode> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ETRkgnode, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(objId).toProperty("objId")
            .map(obj).toProperty("obj")
            .map(color).toProperty("color")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ETRkgnode row) {
        return MyBatis3Utils.insert(this::insert, row, ETRkgnode, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(objId).toPropertyWhenPresent("objId", row::getObjId)
            .map(obj).toPropertyWhenPresent("obj", row::getObj)
            .map(color).toPropertyWhenPresent("color", row::getColor)
            .map(type).toPropertyWhenPresent("type", row::getType)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETRkgnode> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ETRkgnode, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETRkgnode> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ETRkgnode, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ETRkgnode> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ETRkgnode, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ETRkgnode> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ETRkgnode, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ETRkgnode row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(objId).equalTo(row::getObjId)
                .set(obj).equalTo(row::getObj)
                .set(color).equalTo(row::getColor)
                .set(type).equalTo(row::getType)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ETRkgnode row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(objId).equalToWhenPresent(row::getObjId)
                .set(obj).equalToWhenPresent(row::getObj)
                .set(color).equalToWhenPresent(row::getColor)
                .set(type).equalToWhenPresent(row::getType)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ETRkgnode row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(objId).equalTo(row::getObjId)
            .set(obj).equalTo(row::getObj)
            .set(color).equalTo(row::getColor)
            .set(type).equalTo(row::getType)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ETRkgnode row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(objId).equalToWhenPresent(row::getObjId)
            .set(obj).equalToWhenPresent(row::getObj)
            .set(color).equalToWhenPresent(row::getColor)
            .set(type).equalToWhenPresent(row::getType)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}