package com.hbhs.house.pricing.convertor.province_price;

import com.hbhs.house.pricing.domain.criteria.ProvincePriceCriteria;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProvincePriceQueryParam2CriteriaConvertor extends BaseDataConverter<ProvincePriceQueryParam, ProvincePriceCriteria> {
    @Override
    public ProvincePriceCriteria convert(ProvincePriceQueryParam param) {
        ProvincePriceCriteria criteria = new ProvincePriceCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
