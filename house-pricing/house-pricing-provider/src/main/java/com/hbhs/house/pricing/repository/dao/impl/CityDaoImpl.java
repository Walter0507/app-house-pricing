package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.repository.dao.mapper.CityMapper;
import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Slf4j
public class CityDaoImpl implements ICityDao {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Boolean createCity(CityEntity entity) {
        return cityMapper.insertCity(entity);
    }

    @Override
    public Boolean batchCreateCity(List<CityEntity> entityList) {
        return cityMapper.batchInsertCity(entityList);
    }

    @Override
    public Boolean updateCity(CityEntity entity) {
        return cityMapper.updateCity(entity);
    }

    @Override
    public Boolean deletedCity(String id) {
        return cityMapper.deleteCity(id);
    }

    @Override
    @ReadOnlyConnection
    public CityEntity findCityById(String id) {
        return cityMapper.findCityById(id);
    }

    @Override
    public List<CityEntity> findCityByCriteria(CityCriteria criteria, Pagination pagination) {
        return cityMapper.findCityByCriteria(criteria);
    }
}
