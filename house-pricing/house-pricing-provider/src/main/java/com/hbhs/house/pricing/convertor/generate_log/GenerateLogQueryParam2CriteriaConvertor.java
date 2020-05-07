package com.hbhs.house.pricing.convertor.generate_log;

import com.hbhs.house.pricing.domain.criteria.GenerateLogCriteria;
import com.hbhs.house.pricing.domain.request.param.GenerateLogQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GenerateLogQueryParam2CriteriaConvertor extends BaseDataConverter<GenerateLogQueryParam, GenerateLogCriteria> {
    @Override
    public GenerateLogCriteria convert(GenerateLogQueryParam param) {
        GenerateLogCriteria criteria = new GenerateLogCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
