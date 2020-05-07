package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.IProvincePriceDao;
import com.hbhs.house.pricing.repository.dao.mapper.ProvincePriceMapper;
import com.hbhs.house.pricing.domain.criteria.ProvincePriceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvincePriceEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Slf4j
public class ProvincePriceDaoImpl implements IProvincePriceDao {

    @Autowired
    private ProvincePriceMapper provincePriceMapper;

    @Override
    public Boolean createProvincePrice(ProvincePriceEntity entity) {
        return provincePriceMapper.insertProvincePrice(entity);
    }

    @Override
    public Boolean batchCreateProvincePrice(List<ProvincePriceEntity> entityList) {
        return provincePriceMapper.batchInsertProvincePrice(entityList);
    }

    @Override
    public Boolean updateProvincePrice(ProvincePriceEntity entity) {
        return provincePriceMapper.updateProvincePrice(entity);
    }

    @Override
    public Boolean deletedProvincePrice(String id) {
        return provincePriceMapper.deleteProvincePrice(id);
    }

    @Override
    @ReadOnlyConnection
    public ProvincePriceEntity findProvincePriceById(String id) {
        return provincePriceMapper.findProvincePriceById(id);
    }

    @Override
    public List<ProvincePriceEntity> findProvincePriceByCriteria(ProvincePriceCriteria criteria, Pagination pagination) {
        return provincePriceMapper.findProvincePriceByCriteria(criteria);
    }
}
