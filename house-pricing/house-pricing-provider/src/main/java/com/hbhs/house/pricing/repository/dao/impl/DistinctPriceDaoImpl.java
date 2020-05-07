package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.IDistinctPriceDao;
import com.hbhs.house.pricing.repository.dao.mapper.DistinctPriceMapper;
import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository@Slf4j
public class DistinctPriceDaoImpl implements IDistinctPriceDao {

    @Autowired
    private DistinctPriceMapper distinctPriceMapper;

    @Override
    public Boolean createDistinctPrice(DistinctPriceEntity entity) {
        return distinctPriceMapper.insertDistinctPrice(entity);
    }

    @Override
    public Boolean batchCreateDistinctPrice(List<DistinctPriceEntity> entityList) {
        return distinctPriceMapper.batchInsertDistinctPrice(entityList);
    }

    @Override
    public Boolean updateDistinctPrice(DistinctPriceEntity entity) {
        return distinctPriceMapper.updateDistinctPrice(entity);
    }

    @Override
    public Boolean deletedDistinctPrice(String id) {
        return distinctPriceMapper.deleteDistinctPrice(id);
    }

    @Override
    @ReadOnlyConnection
    public DistinctPriceEntity findDistinctPriceById(String id) {
        return distinctPriceMapper.findDistinctPriceById(id);
    }

    @Override
    public List<DistinctPriceEntity> findDistinctPriceByCriteria(DistinctPriceCriteria criteria, Pagination pagination) {
        return distinctPriceMapper.findDistinctPriceByCriteria(criteria);
    }

    @Override
    public List<DistinctPriceEntity> findCityPriceSummaryGroupByCityId(Date startDay, Date endDay,
                                                                           Date startWeek, Date endWeek){
        return distinctPriceMapper.findCityPriceSummaryGroupByCityId(startDay,endDay,startWeek,endWeek);
    }
}
