package com.hbhs.house.pricing.convertor.city;

import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.request.param.CityQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CityQueryParam2CriteriaConvertor extends BaseDataConverter<CityQueryParam, CityCriteria> {
    @Override
    public CityCriteria convert(CityQueryParam param) {
        CityCriteria criteria = new CityCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
