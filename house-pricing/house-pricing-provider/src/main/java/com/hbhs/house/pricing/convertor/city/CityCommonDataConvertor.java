package com.hbhs.house.pricing.convertor.city;

import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.house.pricing.domain.request.param.CityCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CityCommonDataConvertor extends BaseCommonDataConvertor<CityCreateParam , CityUpdateParam, CityInfo, CityEntity> {

    @Override
    public CityEntity createParam2Entity(CityCreateParam param){
        if (param == null){
            return null;
        }
        CityEntity entity = new CityEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public CityEntity updateParam2Entity(CityUpdateParam param) {
        if (param == null){
            return null;
        }
        CityEntity entity = new CityEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public CityInfo entity2Info(CityEntity entity) {
        if (entity == null){
            return null;
        }
        CityInfo info = new CityInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
