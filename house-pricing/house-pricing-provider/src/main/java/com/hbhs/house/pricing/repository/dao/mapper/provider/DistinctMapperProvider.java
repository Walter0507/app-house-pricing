package com.hbhs.house.pricing.repository.dao.mapper.provider;

import com.hbhs.common.tools.utils.StringUtil;
import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

@Slf4j
public class DistinctMapperProvider {

    public String findDistinctByCriteria(@Param("criteria") DistinctCriteria criteria){
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(DistinctMapperConsts.TABLE_NAME).append(" WHERE 1=1");
        // TODO
        if (!StringUtils.isEmpty(criteria.getCityId())){
            str.append(" AND city_id ='").append(criteria.getCityId()).append("'");
        }

        if (log.isDebugEnabled()){
            log.debug("Will execute sql: {}", str);
        }
        return str.toString();
    }
}
