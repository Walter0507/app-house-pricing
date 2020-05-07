package com.hbhs.house.pricing.convertor.distinct_price;

import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctPriceInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DistinctPriceCommonDataConvertor extends BaseCommonDataConvertor<DistinctPriceCreateParam , DistinctPriceUpdateParam, DistinctPriceInfo, DistinctPriceEntity> {

    @Override
    public DistinctPriceEntity createParam2Entity(DistinctPriceCreateParam param){
        if (param == null){
            return null;
        }
        DistinctPriceEntity entity = new DistinctPriceEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public DistinctPriceEntity updateParam2Entity(DistinctPriceUpdateParam param) {
        if (param == null){
            return null;
        }
        DistinctPriceEntity entity = new DistinctPriceEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public DistinctPriceInfo entity2Info(DistinctPriceEntity entity) {
        if (entity == null){
            return null;
        }
        DistinctPriceInfo info = new DistinctPriceInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
