package com.hbhs.house.pricing.repository.dao.mapper;

import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.house.pricing.repository.dao.mapper.provider.DistinctMapperProvider;
import com.hbhs.house.pricing.repository.dao.mapper.provider.DistinctPriceMapperConsts;
import com.hbhs.house.pricing.repository.dao.mapper.provider.DistinctPriceMapperProvider;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

import static com.hbhs.house.pricing.repository.dao.mapper.provider.DistinctPriceMapperConsts.*;

@Mapper
public interface DistinctPriceMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertDistinctPrice(@Param("entity") DistinctPriceEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertDistinctPrice(@Param("entityList") List<DistinctPriceEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateDistinctPrice(@Param("entity") DistinctPriceEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteDistinctPrice(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    DistinctPriceEntity findDistinctPriceById(@Param("id") String id);

    @SelectProvider(type = DistinctPriceMapperProvider.class, method = "findDistinctPriceByCriteria")
    List<DistinctPriceEntity> findDistinctPriceByCriteria(@Param("criteria") DistinctPriceCriteria criteria);

    @Select("<script>" +
            "SELECT city_id,sum(selling_count) selling_count" +
            " FROM "+ TABLE_NAME +
            " WHERE 1 = 1" +
            " <if test='startDay!=null'>AND load_day &gt;= #{startDay}</if>" +
//            " <if test='endDay!=null'>AND load_day &lt; #{endDay}</if>" +
//            " <if test='startWeek!=null'>AND week &gt;= #{startWeek}</if>" +
//            " <if test='endWeek!=null'>AND week &lt; #{endWeek}</if>" +
            " GROUP BY city_id" +
            "</script>")
    List<DistinctPriceEntity> findCityPriceSummaryGroupByCityId(@Param("startDay")Date startDay,
                                                                @Param("endDay")Date endDay,
                                                                @Param("startWeek")Date startWeek,
                                                                @Param("endWeek")Date endWeek);
}
