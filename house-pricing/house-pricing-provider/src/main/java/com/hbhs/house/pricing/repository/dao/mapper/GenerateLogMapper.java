package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.GenerateLogCriteria;
import com.hbhs.house.pricing.domain.entity.GenerateLogEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.GenerateLogMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.GenerateLogMapperConsts.*;

@Mapper
public interface GenerateLogMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertGenerateLog(@Param("entity") GenerateLogEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertGenerateLog(@Param("entityList") List<GenerateLogEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateGenerateLog(@Param("entity") GenerateLogEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteGenerateLog(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    GenerateLogEntity findGenerateLogById(@Param("id") String id);

    @SelectProvider(type = GenerateLogMapperProvider.class, method = "findGenerateLogByCriteria")
    List<GenerateLogEntity> findGenerateLogByCriteria(@Param("criteria") GenerateLogCriteria criteria);

}
