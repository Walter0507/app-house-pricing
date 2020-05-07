package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.DistinctMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.DistinctMapperConsts.*;

@Mapper
public interface DistinctMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertDistinct(@Param("entity") DistinctEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertDistinct(@Param("entityList") List<DistinctEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateDistinct(@Param("entity") DistinctEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteDistinct(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    DistinctEntity findDistinctById(@Param("id") String id);

    @SelectProvider(type = DistinctMapperProvider.class, method = "findDistinctByCriteria")
    List<DistinctEntity> findDistinctByCriteria(@Param("criteria") DistinctCriteria criteria);

}
