package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.IGenerateLogDao;
import com.hbhs.house.pricing.repository.dao.mapper.GenerateLogMapper;
import com.hbhs.house.pricing.domain.criteria.GenerateLogCriteria;
import com.hbhs.house.pricing.domain.entity.GenerateLogEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Slf4j
public class GenerateLogDaoImpl implements IGenerateLogDao {

    @Autowired
    private GenerateLogMapper generateLogMapper;

    @Override
    public Boolean createGenerateLog(GenerateLogEntity entity) {
        return generateLogMapper.insertGenerateLog(entity);
    }

    @Override
    public Boolean batchCreateGenerateLog(List<GenerateLogEntity> entityList) {
        return generateLogMapper.batchInsertGenerateLog(entityList);
    }

    @Override
    public Boolean updateGenerateLog(GenerateLogEntity entity) {
        return generateLogMapper.updateGenerateLog(entity);
    }

    @Override
    public Boolean deletedGenerateLog(String id) {
        return generateLogMapper.deleteGenerateLog(id);
    }

    @Override
    @ReadOnlyConnection
    public GenerateLogEntity findGenerateLogById(String id) {
        return generateLogMapper.findGenerateLogById(id);
    }

    @Override
    public List<GenerateLogEntity> findGenerateLogByCriteria(GenerateLogCriteria criteria, Pagination pagination) {
        return generateLogMapper.findGenerateLogByCriteria(criteria);
    }
}
