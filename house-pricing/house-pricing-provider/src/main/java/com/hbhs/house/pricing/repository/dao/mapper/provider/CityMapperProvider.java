package com.hbhs.house.pricing.repository.dao.mapper.provider;

import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

@Slf4j
public class CityMapperProvider {

    public String findCityByCriteria(@Param("criteria") CityCriteria criteria){
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(CityMapperConsts.TABLE_NAME).append(" WHERE 1=1");
        if (StringUtils.isNotEmpty(criteria.getCityName())){
            str.append(" AND name = '").append(criteria.getCityName()).append("'");
        }
        if (StringUtils.isNotEmpty(criteria.getProvinceId())){
            str.append(" AND province_id = '").append(criteria.getProvinceId()).append("'");
        }

        if (log.isDebugEnabled()){
            log.debug("Will execute sql: {}", str);
        }
        return str.toString();
    }
}
