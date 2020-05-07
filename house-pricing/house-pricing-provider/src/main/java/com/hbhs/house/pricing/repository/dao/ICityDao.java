package com.hbhs.house.pricing.repository.dao;

import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.List;

public interface ICityDao {

    Boolean createCity(CityEntity entity);

    Boolean batchCreateCity(List<CityEntity> entityList);

    Boolean updateCity(CityEntity entity);

    Boolean deletedCity(String id);

    CityEntity findCityById(String id);

    List<CityEntity> findCityByCriteria(CityCriteria criteria, Pagination pagination);
}
