package com.hbhs.house.pricing.repository.dao.mapper.provider;

public class CityMapperConsts {

    public final static String TABLE_NAME = "t_city";

    public final static String FULL_FIELD = "is_deleted,create_time,update_time,id,province_id,name,search_url_lianjia";

    public final static String BASIC_FIELD = "id,province_id,name,search_url_lianjia";

    public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.provinceId},#{entity.name},#{entity.searchUrlLianjia}";

    public final static String UPDATE_SQL_OF_FIELD = "<if test = 'entity.id != null' >id=#{entity.id},</if><if test = 'entity.provinceId != null' >province_id=#{entity.provinceId},</if><if test = 'entity.name != null' >name=#{entity.name},</if><if test = 'entity.searchUrlLianjia != null' >search_url_lianjia=#{entity.searchUrlLianjia},</if>" ;

    /*public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.name},#{entity.type},#{entity.age}";

    public final static String UPDATE_SQL_OF_FIELD = "" +
            "<if test = 'entity.name != null'> name=#{entity.name},</if>" +
            "<if test = 'entity.type != null'> type=#{entity.type},</if>" +
            "<if test = 'entity.age != null'> age=#{entity.age},</if>" ;*/
}
