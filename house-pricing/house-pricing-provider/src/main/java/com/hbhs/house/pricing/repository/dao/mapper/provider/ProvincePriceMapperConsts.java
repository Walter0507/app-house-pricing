package com.hbhs.house.pricing.repository.dao.mapper.provider;

public class ProvincePriceMapperConsts {

    public final static String TABLE_NAME = "t_province_price";

    public final static String FULL_FIELD = "is_deleted,create_time,update_time,id,province_id,week,month,selling_count,selling_avg_price";

    public final static String BASIC_FIELD = "id,province_id,week,month,selling_count,selling_avg_price";

    public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.provinceId},#{entity.week},#{entity.month},#{entity.sellingCount},#{entity.sellingAvgPrice}";

    public final static String UPDATE_SQL_OF_FIELD = "<if test = 'entity.id != null' >id=#{entity.id},</if><if test = 'entity.provinceId != null' >province_id=#{entity.provinceId},</if><if test = 'entity.week != null' >week=#{entity.week},</if><if test = 'entity.month != null' >month=#{entity.month},</if><if test = 'entity.sellingCount != null' >selling_count=#{entity.sellingCount},</if><if test = 'entity.sellingAvgPrice != null' >selling_avg_price=#{entity.sellingAvgPrice},</if>" ;

    /*public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.name},#{entity.type},#{entity.age}";

    public final static String UPDATE_SQL_OF_FIELD = "" +
            "<if test = 'entity.name != null'> name=#{entity.name},</if>" +
            "<if test = 'entity.type != null'> type=#{entity.type},</if>" +
            "<if test = 'entity.age != null'> age=#{entity.age},</if>" ;*/
}
