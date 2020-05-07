package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.ICityPriceDao;
import com.hbhs.house.pricing.repository.dao.mapper.CityPriceMapper;
import com.hbhs.house.pricing.domain.criteria.CityPriceCriteria;
import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository@Slf4j
public class CityPriceDaoImpl implements ICityPriceDao {

    @Autowired
    private CityPriceMapper cityPriceMapper;

    @Override
    public Boolean createCityPrice(CityPriceEntity entity) {
        return cityPriceMapper.insertCityPrice(entity);
    }

    @Override
    public Boolean batchCreateCityPrice(List<CityPriceEntity> entityList) {
        return cityPriceMapper.batchInsertCityPrice(entityList);
    }

    @Override
    public Boolean updateCityPrice(CityPriceEntity entity) {
        return cityPriceMapper.updateCityPrice(entity);
    }

    @Override
    public Boolean deletedCityPrice(String id) {
        return cityPriceMapper.deleteCityPrice(id);
    }

    @Override
    @ReadOnlyConnection
    public CityPriceEntity findCityPriceById(String id) {
        return cityPriceMapper.findCityPriceById(id);
    }

    @Override
    public List<CityPriceEntity> findCityPriceByCriteria(CityPriceCriteria criteria, Pagination pagination) {
        return cityPriceMapper.findCityPriceByCriteria(criteria);
    }
    @Override
    public boolean deleteCityPrice(Date startDay, Date endDay,
                                   Date startWeek, Date endWeek){
        return cityPriceMapper.deleteCityPriceByDate(startDay,endDay,startWeek,endWeek);
    }
}
