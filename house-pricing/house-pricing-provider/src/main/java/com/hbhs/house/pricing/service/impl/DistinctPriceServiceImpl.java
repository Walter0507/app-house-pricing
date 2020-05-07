package com.hbhs.house.pricing.service.impl;

import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.house.pricing.convertor.distinct_price.DistinctPriceCommonDataConvertor;
import com.hbhs.house.pricing.convertor.distinct_price.DistinctPriceQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctPriceInfo;
import com.hbhs.house.pricing.repository.dao.IDistinctPriceDao;
import com.hbhs.house.pricing.service.IDistinctPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DistinctPriceServiceImpl implements IDistinctPriceService {
    @Autowired
    private IDistinctPriceDao distinctPriceDao;
    @Autowired
    private DistinctPriceCommonDataConvertor commonDataConvertor;
    @Autowired
    private DistinctPriceQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public DistinctPriceInfo createDistinctPrice(DistinctPriceCreateParam param) {
        DistinctPriceEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = distinctPriceDao.createDistinctPrice(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateDistinctPrice(DistinctPriceUpdateParam param) {
        DistinctPriceEntity entity = commonDataConvertor.updateParam2Entity(param);
        return distinctPriceDao.updateDistinctPrice(entity);
    }

    @Override
    public Boolean deleteDistinctPrice(String id) {
        return distinctPriceDao.deletedDistinctPrice(id);
    }

    @Override
    public DistinctPriceInfo findDistinctPriceById(String id) {
        DistinctPriceEntity entity = distinctPriceDao.findDistinctPriceById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<DistinctPriceInfo> queryDistinctPrice(DistinctPriceQueryParam param, Pagination pagination) {
        DistinctPriceCriteria criteria = criteriaConvertor.convert(param);

        List<DistinctPriceEntity> entityList = distinctPriceDao.findDistinctPriceByCriteria(criteria, pagination);

        List<DistinctPriceInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<DistinctPriceInfo> result = TResultBuilder.succPageResult(DistinctPriceInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
