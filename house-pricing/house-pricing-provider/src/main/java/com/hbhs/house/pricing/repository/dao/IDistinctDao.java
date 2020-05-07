package com.hbhs.house.pricing.repository.dao;

import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.List;

public interface IDistinctDao {

    Boolean createDistinct(DistinctEntity entity);

    Boolean batchCreateDistinct(List<DistinctEntity> entityList);

    Boolean updateDistinct(DistinctEntity entity);

    Boolean deletedDistinct(String id);

    DistinctEntity findDistinctById(String id);

    List<DistinctEntity> findDistinctByCriteria(DistinctCriteria criteria, Pagination pagination);
}
