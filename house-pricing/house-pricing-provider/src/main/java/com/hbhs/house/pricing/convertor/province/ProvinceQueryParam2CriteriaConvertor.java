package com.hbhs.house.pricing.convertor.province;

import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.request.param.ProvinceQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProvinceQueryParam2CriteriaConvertor extends BaseDataConverter<ProvinceQueryParam, ProvinceCriteria> {
    @Override
    public ProvinceCriteria convert(ProvinceQueryParam param) {
        ProvinceCriteria criteria = new ProvinceCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
