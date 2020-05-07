package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.IDistinctDao;
import com.hbhs.house.pricing.repository.dao.mapper.DistinctMapper;
import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Slf4j
public class DistinctDaoImpl implements IDistinctDao {

    @Autowired
    private DistinctMapper distinctMapper;

    @Override
    public Boolean createDistinct(DistinctEntity entity) {
        return distinctMapper.insertDistinct(entity);
    }

    @Override
    public Boolean batchCreateDistinct(List<DistinctEntity> entityList) {
        return distinctMapper.batchInsertDistinct(entityList);
    }

    @Override
    public Boolean updateDistinct(DistinctEntity entity) {
        return distinctMapper.updateDistinct(entity);
    }

    @Override
    public Boolean deletedDistinct(String id) {
        return distinctMapper.deleteDistinct(id);
    }

    @Override
    @ReadOnlyConnection
    public DistinctEntity findDistinctById(String id) {
        return distinctMapper.findDistinctById(id);
    }

    @Override
    public List<DistinctEntity> findDistinctByCriteria(DistinctCriteria criteria, Pagination pagination) {
        return distinctMapper.findDistinctByCriteria(criteria);
    }
}
