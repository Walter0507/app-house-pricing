package com.hbhs.house.pricing.repository.dao;

import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;

import java.util.Date;
import java.util.List;

public interface IDistinctPriceDao {

    Boolean createDistinctPrice(DistinctPriceEntity entity);

    Boolean batchCreateDistinctPrice(List<DistinctPriceEntity> entityList);

    Boolean updateDistinctPrice(DistinctPriceEntity entity);

    Boolean deletedDistinctPrice(String id);

    DistinctPriceEntity findDistinctPriceById(String id);

    List<DistinctPriceEntity> findDistinctPriceByCriteria(DistinctPriceCriteria criteria, Pagination pagination);

    List<DistinctPriceEntity> findCityPriceSummaryGroupByCityId(Date startDay, Date endDay,
                                                                Date startWeek, Date endWeek);
}
