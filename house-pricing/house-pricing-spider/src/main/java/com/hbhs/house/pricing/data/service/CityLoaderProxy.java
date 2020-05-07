package com.hbhs.house.pricing.data.service;

import com.hbhs.common.tools.id.mongodb.ObjectId;
import com.hbhs.house.pricing.data.convertor.CrawlEntityConventor;
import com.hbhs.house.pricing.data.convertor.LocalCacheService;
import com.hbhs.house.pricing.data.dto.CrawlCity;
import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.repository.dao.IProvinceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CityLoaderProxy {
    @Autowired
    private CrawlEntityConventor conventor;
    @Autowired
    private LocalCacheService localCacheService;
    @Autowired
    private ICityDao cityDao;

    public void saveCity(List<CrawlCity> cityList) {
        if (cityList == null || cityList.size() == 0) {
            return;
        }
        cityList.removeIf(city -> localCacheService.findCityId(city.getProvinceName(),city.getCityName())!=null);

        if (cityList.size() > 0) {
            List<CityEntity> entityList = conventor.convertCity(cityList);
            for (CityEntity entity : entityList) {
                entity.setId(ObjectId.get().toString());
                cityDao.createCity(entity);
            }
        }
    }

}
