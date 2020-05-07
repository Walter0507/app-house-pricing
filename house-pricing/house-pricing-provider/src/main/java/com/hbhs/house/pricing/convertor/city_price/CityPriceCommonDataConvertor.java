package com.hbhs.house.pricing.convertor.city_price;

import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import com.hbhs.house.pricing.domain.request.param.CityPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityPriceInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CityPriceCommonDataConvertor extends BaseCommonDataConvertor<CityPriceCreateParam , CityPriceUpdateParam, CityPriceInfo, CityPriceEntity> {

    @Override
    public CityPriceEntity createParam2Entity(CityPriceCreateParam param){
        if (param == null){
            return null;
        }
        CityPriceEntity entity = new CityPriceEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public CityPriceEntity updateParam2Entity(CityPriceUpdateParam param) {
        if (param == null){
            return null;
        }
        CityPriceEntity entity = new CityPriceEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public CityPriceInfo entity2Info(CityPriceEntity entity) {
        if (entity == null){
            return null;
        }
        CityPriceInfo info = new CityPriceInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
