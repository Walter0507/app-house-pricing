package com.hbhs.house.pricing.repository.dao.mapper.provider;

public class GenerateLogMapperConsts {

    public final static String TABLE_NAME = "t_generate_log";

    public final static String FULL_FIELD = "is_deleted,create_time,update_time,type,id,load_day";

    public final static String BASIC_FIELD = "type,id,load_day";

    public final static String BASIC_FIELD_OF_ENTITY = "#{entity.type},#{entity.id},#{entity.loadDay}";

    public final static String UPDATE_SQL_OF_FIELD = "<if test = 'entity.type != null' >type=#{entity.type},</if><if test = 'entity.id != null' >id=#{entity.id},</if><if test = 'entity.loadDay != null' >load_day=#{entity.loadDay},</if>" ;

    /*public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.name},#{entity.type},#{entity.age}";

    public final static String UPDATE_SQL_OF_FIELD = "" +
            "<if test = 'entity.name != null'> name=#{entity.name},</if>" +
            "<if test = 'entity.type != null'> type=#{entity.type},</if>" +
            "<if test = 'entity.age != null'> age=#{entity.age},</if>" ;*/
}
