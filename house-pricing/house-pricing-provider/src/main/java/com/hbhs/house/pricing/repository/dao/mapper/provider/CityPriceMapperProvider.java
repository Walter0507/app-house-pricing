package com.hbhs.house.pricing.repository.dao.mapper.provider;

import com.hbhs.house.pricing.domain.criteria.CityPriceCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

@Slf4j
public class CityPriceMapperProvider {

    public String findCityPriceByCriteria(@Param("criteria") CityPriceCriteria criteria){
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(CityPriceMapperConsts.TABLE_NAME).append(" WHERE 1=1");
        // TODO

        if (log.isDebugEnabled()){
            log.debug("Will execute sql: {}", str);
        }
        return str.toString();
    }
}
