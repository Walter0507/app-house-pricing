package com.hbhs.house.pricing.convertor.distinct;

import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.request.param.DistinctQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DistinctQueryParam2CriteriaConvertor extends BaseDataConverter<DistinctQueryParam, DistinctCriteria> {
    @Override
    public DistinctCriteria convert(DistinctQueryParam param) {
        DistinctCriteria criteria = new DistinctCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
