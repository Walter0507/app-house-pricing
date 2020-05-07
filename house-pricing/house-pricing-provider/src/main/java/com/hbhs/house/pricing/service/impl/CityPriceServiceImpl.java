package com.hbhs.house.pricing.service.impl;

import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.house.pricing.convertor.city_price.CityPriceCommonDataConvertor;
import com.hbhs.house.pricing.convertor.city_price.CityPriceQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.domain.criteria.CityPriceCriteria;
import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import com.hbhs.house.pricing.domain.request.param.CityPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityPriceInfo;
import com.hbhs.house.pricing.repository.dao.ICityPriceDao;
import com.hbhs.house.pricing.service.ICityPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityPriceServiceImpl implements ICityPriceService {
    @Autowired
    private ICityPriceDao cityPriceDao;
    @Autowired
    private CityPriceCommonDataConvertor commonDataConvertor;
    @Autowired
    private CityPriceQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public CityPriceInfo createCityPrice(CityPriceCreateParam param) {
        CityPriceEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = cityPriceDao.createCityPrice(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateCityPrice(CityPriceUpdateParam param) {
        CityPriceEntity entity = commonDataConvertor.updateParam2Entity(param);
        return cityPriceDao.updateCityPrice(entity);
    }

    @Override
    public Boolean deleteCityPrice(String id) {
        return cityPriceDao.deletedCityPrice(id);
    }

    @Override
    public CityPriceInfo findCityPriceById(String id) {
        CityPriceEntity entity = cityPriceDao.findCityPriceById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<CityPriceInfo> queryCityPrice(CityPriceQueryParam param, Pagination pagination) {
        CityPriceCriteria criteria = criteriaConvertor.convert(param);

        List<CityPriceEntity> entityList = cityPriceDao.findCityPriceByCriteria(criteria, pagination);

        List<CityPriceInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<CityPriceInfo> result = TResultBuilder.succPageResult(CityPriceInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
