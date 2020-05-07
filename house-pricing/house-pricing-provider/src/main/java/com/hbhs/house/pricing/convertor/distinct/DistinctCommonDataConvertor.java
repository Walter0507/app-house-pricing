package com.hbhs.house.pricing.convertor.distinct;

import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.house.pricing.domain.request.param.DistinctCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DistinctCommonDataConvertor extends BaseCommonDataConvertor<DistinctCreateParam , DistinctUpdateParam, DistinctInfo, DistinctEntity> {

    @Override
    public DistinctEntity createParam2Entity(DistinctCreateParam param){
        if (param == null){
            return null;
        }
        DistinctEntity entity = new DistinctEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public DistinctEntity updateParam2Entity(DistinctUpdateParam param) {
        if (param == null){
            return null;
        }
        DistinctEntity entity = new DistinctEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public DistinctInfo entity2Info(DistinctEntity entity) {
        if (entity == null){
            return null;
        }
        DistinctInfo info = new DistinctInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
