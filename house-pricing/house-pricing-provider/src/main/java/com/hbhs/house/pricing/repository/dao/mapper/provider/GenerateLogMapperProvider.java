package com.hbhs.house.pricing.repository.dao.mapper.provider;

import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.criteria.GenerateLogCriteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

@Slf4j
public class GenerateLogMapperProvider {

    public String findGenerateLogByCriteria(@Param("criteria") GenerateLogCriteria criteria){
        StringBuilder str = new StringBuilder();
        str.append("SELECT * FROM ").append(GenerateLogMapperConsts.TABLE_NAME).append(" WHERE 1=1");
        // TODO

        if (log.isDebugEnabled()){
            log.debug("Will execute sql: {}", str);
        }
        return str.toString();
    }
}
