package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.CityMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.CityMapperConsts.*;

@Mapper
public interface CityMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertCity(@Param("entity") CityEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertCity(@Param("entityList") List<CityEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateCity(@Param("entity") CityEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteCity(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    CityEntity findCityById(@Param("id") String id);

    @SelectProvider(type = CityMapperProvider.class, method = "findCityByCriteria")
    List<CityEntity> findCityByCriteria(@Param("criteria") CityCriteria criteria);

}
