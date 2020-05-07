package com.hbhs.house.pricing.service.impl;

import com.hbhs.house.pricing.convertor.city.CityCommonDataConvertor;
import com.hbhs.house.pricing.convertor.city.CityQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.house.pricing.domain.request.param.CityCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.house.pricing.service.ICityService;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements ICityService {
    @Autowired
    private ICityDao cityDao;
    @Autowired
    private CityCommonDataConvertor commonDataConvertor;
    @Autowired
    private CityQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public CityInfo createCity(CityCreateParam param) {
        CityEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = cityDao.createCity(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateCity(CityUpdateParam param) {
        CityEntity entity = commonDataConvertor.updateParam2Entity(param);
        return cityDao.updateCity(entity);
    }

    @Override
    public Boolean deleteCity(String id) {
        return cityDao.deletedCity(id);
    }

    @Override
    public CityInfo findCityById(String id) {
        CityEntity entity = cityDao.findCityById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<CityInfo> queryCity(CityQueryParam param, Pagination pagination) {
        CityCriteria criteria = criteriaConvertor.convert(param);

        List<CityEntity> entityList = cityDao.findCityByCriteria(criteria, pagination);

        List<CityInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<CityInfo> result = TResultBuilder.succPageResult(CityInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
