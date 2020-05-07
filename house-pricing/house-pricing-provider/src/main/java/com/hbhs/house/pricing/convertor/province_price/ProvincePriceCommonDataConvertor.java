package com.hbhs.house.pricing.convertor.province_price;

import com.hbhs.house.pricing.domain.entity.ProvincePriceEntity;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvincePriceInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProvincePriceCommonDataConvertor extends BaseCommonDataConvertor<ProvincePriceCreateParam , ProvincePriceUpdateParam, ProvincePriceInfo, ProvincePriceEntity> {

    @Override
    public ProvincePriceEntity createParam2Entity(ProvincePriceCreateParam param){
        if (param == null){
            return null;
        }
        ProvincePriceEntity entity = new ProvincePriceEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public ProvincePriceEntity updateParam2Entity(ProvincePriceUpdateParam param) {
        if (param == null){
            return null;
        }
        ProvincePriceEntity entity = new ProvincePriceEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public ProvincePriceInfo entity2Info(ProvincePriceEntity entity) {
        if (entity == null){
            return null;
        }
        ProvincePriceInfo info = new ProvincePriceInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
