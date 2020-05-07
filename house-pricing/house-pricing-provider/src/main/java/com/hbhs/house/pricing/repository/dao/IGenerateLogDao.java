package com.hbhs.house.pricing.repository.dao;

import com.hbhs.house.pricing.domain.criteria.GenerateLogCriteria;
import com.hbhs.house.pricing.domain.entity.GenerateLogEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.List;

public interface IGenerateLogDao {

    Boolean createGenerateLog(GenerateLogEntity entity);

    Boolean batchCreateGenerateLog(List<GenerateLogEntity> entityList);

    Boolean updateGenerateLog(GenerateLogEntity entity);

    Boolean deletedGenerateLog(String id);

    GenerateLogEntity findGenerateLogById(String id);

    List<GenerateLogEntity> findGenerateLogByCriteria(GenerateLogCriteria criteria, Pagination pagination);
}
