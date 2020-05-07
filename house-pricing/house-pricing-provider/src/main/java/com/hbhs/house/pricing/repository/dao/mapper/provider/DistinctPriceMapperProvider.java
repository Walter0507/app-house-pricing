package com.hbhs.house.pricing.repository.dao.mapper.provider;

import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

@Slf4j
public class DistinctPriceMapperProvider {

    public String findDistinctPriceByCriteria(@Param("criteria") DistinctPriceCriteria criteria){
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(DistinctPriceMapperConsts.TABLE_NAME).append(" WHERE 1=1");
        if (StringUtils.isNotEmpty(criteria.getProvinceId())){
            str.append(" AND province_id = '").append(criteria.getProvinceId()).append("' ");
        }
        if (StringUtils.isNotEmpty(criteria.getCityId())){
            str.append(" AND city_id = '").append(criteria.getCityId()).append("' ");
        }
        if (StringUtils.isNotEmpty(criteria.getDistinctId())){
            str.append(" AND distinct_id = '").append(criteria.getDistinctId()).append("' ");
        }
        if (criteria.getStartDay()!=null&&criteria.getEndDay()!=null){
            str.append(" AND load_day between #{criteria.startDay} AND #{criteria.endDay}");
        }

        if (criteria.getStartWeek()!=null&&criteria.getEndWeek()!=null){
            str.append(" AND week between #{criteria.startWeek} AND #{criteria.endWeek}");
        }

        if (log.isDebugEnabled()){
            log.debug("Will execute sql: {}", str);
        }
        return str.toString();
    }
}
