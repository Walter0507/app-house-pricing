package com.hbhs.house.pricing.convertor.generate_log;

import com.hbhs.house.pricing.domain.entity.GenerateLogEntity;
import com.hbhs.house.pricing.domain.request.param.GenerateLogCreateParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogUpdateParam;
import com.hbhs.house.pricing.domain.response.info.GenerateLogInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GenerateLogCommonDataConvertor extends BaseCommonDataConvertor<GenerateLogCreateParam , GenerateLogUpdateParam, GenerateLogInfo, GenerateLogEntity> {

    @Override
    public GenerateLogEntity createParam2Entity(GenerateLogCreateParam param){
        if (param == null){
            return null;
        }
        GenerateLogEntity entity = new GenerateLogEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public GenerateLogEntity updateParam2Entity(GenerateLogUpdateParam param) {
        if (param == null){
            return null;
        }
        GenerateLogEntity entity = new GenerateLogEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public GenerateLogInfo entity2Info(GenerateLogEntity entity) {
        if (entity == null){
            return null;
        }
        GenerateLogInfo info = new GenerateLogInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
