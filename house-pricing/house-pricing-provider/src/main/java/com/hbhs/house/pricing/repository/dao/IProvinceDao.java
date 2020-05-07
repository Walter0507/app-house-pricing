package com.hbhs.house.pricing.repository.dao;

import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.List;

public interface IProvinceDao {

    Boolean createProvince(ProvinceEntity entity);

    Boolean batchCreateProvince(List<ProvinceEntity> entityList);

    Boolean updateProvince(ProvinceEntity entity);

    Boolean deletedProvince(String id);

    ProvinceEntity findProvinceById(String id);

    List<ProvinceEntity> findProvinceByCriteria(ProvinceCriteria criteria, Pagination pagination);
}
