package com.hbhs.house.pricing.convertor.city_price;

import com.hbhs.house.pricing.domain.criteria.CityPriceCriteria;
import com.hbhs.house.pricing.domain.request.param.CityPriceQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CityPriceQueryParam2CriteriaConvertor extends BaseDataConverter<CityPriceQueryParam, CityPriceCriteria> {
    @Override
    public CityPriceCriteria convert(CityPriceQueryParam param) {
        CityPriceCriteria criteria = new CityPriceCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
