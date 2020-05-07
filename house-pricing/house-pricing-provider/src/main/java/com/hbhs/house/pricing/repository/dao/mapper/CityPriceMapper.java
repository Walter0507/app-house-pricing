package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.CityPriceCriteria;
import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.CityPriceMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.CityPriceMapperConsts.*;

@Mapper
public interface CityPriceMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertCityPrice(@Param("entity") CityPriceEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertCityPrice(@Param("entityList") List<CityPriceEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateCityPrice(@Param("entity") CityPriceEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteCityPrice(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    CityPriceEntity findCityPriceById(@Param("id") String id);

    @SelectProvider(type = CityPriceMapperProvider.class, method = "findCityPriceByCriteria")
    List<CityPriceEntity> findCityPriceByCriteria(@Param("criteria") CityPriceCriteria criteria);

    @Delete("<script>" +
            "UPDATE "+TABLE_NAME + " SET is_deleted = 1, update_time = NOW() " +
            " WHERE 1=1 "+
            " <if test = 'startDay!=null' >AND load_day &gt;= #{startDay}</if>" +
            " <if test = 'endDay!=null'>AND load_day &lt; #{endDay}</if>" +
            " <if test = 'startWeek!=null'>AND week &gt;= #{startWeek}</if>" +
            " <if test = 'endWeek!=null'>AND week &lt; #{endWeek}</if>" +
            "</script>")
    boolean deleteCityPriceByDate(@Param("startDay") Date startDay,
                            @Param("endDay") Date endDay,
                            @Param("startWeek") Date startWeek,
                            @Param("endWeek") Date endWeek);
}
