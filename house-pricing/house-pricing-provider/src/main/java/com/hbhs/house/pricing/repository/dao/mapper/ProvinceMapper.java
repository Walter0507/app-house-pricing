package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.ProvinceMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.ProvinceMapperConsts.*;

@Mapper
public interface ProvinceMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertProvince(@Param("entity") ProvinceEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertProvince(@Param("entityList") List<ProvinceEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateProvince(@Param("entity") ProvinceEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteProvince(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    ProvinceEntity findProvinceById(@Param("id") String id);

    @SelectProvider(type = ProvinceMapperProvider.class, method = "findProvinceByCriteria")
    List<ProvinceEntity> findProvinceByCriteria(@Param("criteria") ProvinceCriteria criteria);

}
