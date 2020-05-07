package com.hbhs.house.pricing.convertor.province;

import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.house.pricing.domain.request.param.ProvinceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProvinceCommonDataConvertor extends BaseCommonDataConvertor<ProvinceCreateParam , ProvinceUpdateParam, ProvinceInfo, ProvinceEntity> {

    @Override
    public ProvinceEntity createParam2Entity(ProvinceCreateParam param){
        if (param == null){
            return null;
        }
        ProvinceEntity entity = new ProvinceEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public ProvinceEntity updateParam2Entity(ProvinceUpdateParam param) {
        if (param == null){
            return null;
        }
        ProvinceEntity entity = new ProvinceEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public ProvinceInfo entity2Info(ProvinceEntity entity) {
        if (entity == null){
            return null;
        }
        ProvinceInfo info = new ProvinceInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
