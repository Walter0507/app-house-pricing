package com.hbhs.house.pricing.repository.dao;

import com.hbhs.house.pricing.domain.criteria.ProvincePriceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvincePriceEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.List;

public interface IProvincePriceDao {

    Boolean createProvincePrice(ProvincePriceEntity entity);

    Boolean batchCreateProvincePrice(List<ProvincePriceEntity> entityList);

    Boolean updateProvincePrice(ProvincePriceEntity entity);

    Boolean deletedProvincePrice(String id);

    ProvincePriceEntity findProvincePriceById(String id);

    List<ProvincePriceEntity> findProvincePriceByCriteria(ProvincePriceCriteria criteria, Pagination pagination);
}
