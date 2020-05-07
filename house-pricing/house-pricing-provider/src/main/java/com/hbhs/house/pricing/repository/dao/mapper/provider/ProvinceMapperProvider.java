package com.hbhs.house.pricing.repository.dao.mapper.provider;

import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

@Slf4j
public class ProvinceMapperProvider {

    public String findProvinceByCriteria(@Param("criteria") ProvinceCriteria criteria){
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(ProvinceMapperConsts.TABLE_NAME).append(" WHERE 1=1");
        if (StringUtils.isNotEmpty(criteria.getProvinceName())){
            str.append(" AND name = '").append(criteria.getProvinceName()).append("'");
        }
        if (StringUtils.isNotEmpty(criteria.getProvinceNameLike())){
            str.append(" AND name LIKE '%").append(criteria.getProvinceNameLike()).append("%'");
        }

        if (log.isDebugEnabled()){
            log.debug("Will execute sql: {}", str);
        }
        return str.toString();
    }
}
