package com.hbhs.house.pricing.service.impl;

import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.house.pricing.convertor.province_price.ProvincePriceCommonDataConvertor;
import com.hbhs.house.pricing.convertor.province_price.ProvincePriceQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.domain.criteria.ProvincePriceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvincePriceEntity;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvincePriceInfo;
import com.hbhs.house.pricing.repository.dao.IProvincePriceDao;
import com.hbhs.house.pricing.service.IProvincePriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProvincePriceServiceImpl implements IProvincePriceService {
    @Autowired
    private IProvincePriceDao provincePriceDao;
    @Autowired
    private ProvincePriceCommonDataConvertor commonDataConvertor;
    @Autowired
    private ProvincePriceQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public ProvincePriceInfo createProvincePrice(ProvincePriceCreateParam param) {
        ProvincePriceEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = provincePriceDao.createProvincePrice(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateProvincePrice(ProvincePriceUpdateParam param) {
        ProvincePriceEntity entity = commonDataConvertor.updateParam2Entity(param);
        return provincePriceDao.updateProvincePrice(entity);
    }

    @Override
    public Boolean deleteProvincePrice(String id) {
        return provincePriceDao.deletedProvincePrice(id);
    }

    @Override
    public ProvincePriceInfo findProvincePriceById(String id) {
        ProvincePriceEntity entity = provincePriceDao.findProvincePriceById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<ProvincePriceInfo> queryProvincePrice(ProvincePriceQueryParam param, Pagination pagination) {
        ProvincePriceCriteria criteria = criteriaConvertor.convert(param);

        List<ProvincePriceEntity> entityList = provincePriceDao.findProvincePriceByCriteria(criteria, pagination);

        List<ProvincePriceInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<ProvincePriceInfo> result = TResultBuilder.succPageResult(ProvincePriceInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
