package com.hbhs.house.pricing.service.impl;

import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.house.pricing.convertor.generate_log.GenerateLogCommonDataConvertor;
import com.hbhs.house.pricing.convertor.generate_log.GenerateLogQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.domain.criteria.GenerateLogCriteria;
import com.hbhs.house.pricing.domain.entity.GenerateLogEntity;
import com.hbhs.house.pricing.domain.request.param.GenerateLogCreateParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogQueryParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogUpdateParam;
import com.hbhs.house.pricing.domain.response.info.GenerateLogInfo;
import com.hbhs.house.pricing.repository.dao.IGenerateLogDao;
import com.hbhs.house.pricing.service.IGenerateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenerateLogServiceImpl implements IGenerateLogService {
    @Autowired
    private IGenerateLogDao generateLogDao;
    @Autowired
    private GenerateLogCommonDataConvertor commonDataConvertor;
    @Autowired
    private GenerateLogQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public GenerateLogInfo createGenerateLog(GenerateLogCreateParam param) {
        GenerateLogEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = generateLogDao.createGenerateLog(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateGenerateLog(GenerateLogUpdateParam param) {
        GenerateLogEntity entity = commonDataConvertor.updateParam2Entity(param);
        return generateLogDao.updateGenerateLog(entity);
    }

    @Override
    public Boolean deleteGenerateLog(String id) {
        return generateLogDao.deletedGenerateLog(id);
    }

    @Override
    public GenerateLogInfo findGenerateLogById(String id) {
        GenerateLogEntity entity = generateLogDao.findGenerateLogById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<GenerateLogInfo> queryGenerateLog(GenerateLogQueryParam param, Pagination pagination) {
        GenerateLogCriteria criteria = criteriaConvertor.convert(param);

        List<GenerateLogEntity> entityList = generateLogDao.findGenerateLogByCriteria(criteria, pagination);

        List<GenerateLogInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<GenerateLogInfo> result = TResultBuilder.succPageResult(GenerateLogInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
