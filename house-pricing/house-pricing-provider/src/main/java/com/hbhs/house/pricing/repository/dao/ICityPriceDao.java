package com.hbhs.house.pricing.repository.dao;

import com.hbhs.house.pricing.domain.criteria.CityPriceCriteria;
import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.Date;
import java.util.List;

public interface ICityPriceDao {

    Boolean createCityPrice(CityPriceEntity entity);

    Boolean batchCreateCityPrice(List<CityPriceEntity> entityList);

    Boolean updateCityPrice(CityPriceEntity entity);

    Boolean deletedCityPrice(String id);

    CityPriceEntity findCityPriceById(String id);

    List<CityPriceEntity> findCityPriceByCriteria(CityPriceCriteria criteria, Pagination pagination);

    boolean deleteCityPrice(Date startDay, Date endDay,
                         Date startWeek, Date endWeek);
}
