package com.hbhs.house.pricing.convertor.distinct_price;

import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DistinctPriceQueryParam2CriteriaConvertor extends BaseDataConverter<DistinctPriceQueryParam, DistinctPriceCriteria> {
    @Override
    public DistinctPriceCriteria convert(DistinctPriceQueryParam param) {
        DistinctPriceCriteria criteria = new DistinctPriceCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
