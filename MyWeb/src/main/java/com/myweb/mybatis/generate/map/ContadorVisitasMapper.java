package com.myweb.mybatis.generate.map;

import static com.myweb.mybatis.generate.map.ContadorVisitasDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.myweb.mybatis.generate.model.ContadorVisitas;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ContadorVisitasMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, pais, fecha, ip, clicked);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<ContadorVisitas> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ContadorVisitas> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ContadorVisitasResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="pais", property="pais", jdbcType=JdbcType.VARCHAR),
        @Result(column="fecha", property="fecha", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="clicked", property="clicked", jdbcType=JdbcType.BIT)
    })
    List<ContadorVisitas> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ContadorVisitasResult")
    Optional<ContadorVisitas> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, contadorVisitas, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, contadorVisitas, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ContadorVisitas row) {
        return MyBatis3Utils.insert(this::insert, row, contadorVisitas, c ->
            c.map(pais).toProperty("pais")
            .map(fecha).toProperty("fecha")
            .map(ip).toProperty("ip")
            .map(clicked).toProperty("clicked")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ContadorVisitas> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, contadorVisitas, c ->
            c.map(pais).toProperty("pais")
            .map(fecha).toProperty("fecha")
            .map(ip).toProperty("ip")
            .map(clicked).toProperty("clicked")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ContadorVisitas row) {
        return MyBatis3Utils.insert(this::insert, row, contadorVisitas, c ->
            c.map(pais).toPropertyWhenPresent("pais", row::getPais)
            .map(fecha).toPropertyWhenPresent("fecha", row::getFecha)
            .map(ip).toPropertyWhenPresent("ip", row::getIp)
            .map(clicked).toPropertyWhenPresent("clicked", row::getClicked)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContadorVisitas> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, contadorVisitas, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContadorVisitas> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, contadorVisitas, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ContadorVisitas> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, contadorVisitas, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ContadorVisitas> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, contadorVisitas, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ContadorVisitas row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pais).equalTo(row::getPais)
                .set(fecha).equalTo(row::getFecha)
                .set(ip).equalTo(row::getIp)
                .set(clicked).equalTo(row::getClicked);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ContadorVisitas row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pais).equalToWhenPresent(row::getPais)
                .set(fecha).equalToWhenPresent(row::getFecha)
                .set(ip).equalToWhenPresent(row::getIp)
                .set(clicked).equalToWhenPresent(row::getClicked);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ContadorVisitas row) {
        return update(c ->
            c.set(pais).equalTo(row::getPais)
            .set(fecha).equalTo(row::getFecha)
            .set(ip).equalTo(row::getIp)
            .set(clicked).equalTo(row::getClicked)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ContadorVisitas row) {
        return update(c ->
            c.set(pais).equalToWhenPresent(row::getPais)
            .set(fecha).equalToWhenPresent(row::getFecha)
            .set(ip).equalToWhenPresent(row::getIp)
            .set(clicked).equalToWhenPresent(row::getClicked)
            .where(id, isEqualTo(row::getId))
        );
    }
}