package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.ProvincePriceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvincePriceEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.ProvincePriceMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.ProvincePriceMapperConsts.*;

@Mapper
public interface ProvincePriceMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertProvincePrice(@Param("entity") ProvincePriceEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertProvincePrice(@Param("entityList") List<ProvincePriceEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateProvincePrice(@Param("entity") ProvincePriceEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteProvincePrice(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    ProvincePriceEntity findProvincePriceById(@Param("id") String id);

    @SelectProvider(type = ProvincePriceMapperProvider.class, method = "findProvincePriceByCriteria")
    List<ProvincePriceEntity> findProvincePriceByCriteria(@Param("criteria") ProvincePriceCriteria criteria);

}
