package com.hbhs.house.pricing.data.convertor;

import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.repository.dao.IDistinctDao;
import com.hbhs.house.pricing.repository.dao.IProvinceDao;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class LocalCacheService {

    @Getter
    private Map<String, String> provinceNameAndIdMap = new HashMap<>();
    @Getter
    private Map<String, ProvinceEntity> provinceIdAndNameMap = new HashMap<>();
    @Getter
    private Map<String, String> cityNameAndIdMap = new HashMap<>();
    @Getter
    private Map<String, CityEntity> cityIdAndNameMap = new HashMap<>();
    @Getter
    private Map<String, String> distinctNameAndIdMap = new HashMap<>();
    @Getter
    private Map<String, DistinctEntity> distinctIdAndNameMap = new HashMap<>();

    @Autowired
    private IProvinceDao provinceDao;
    @Autowired
    private ICityDao cityDao;
    @Autowired
    private IDistinctDao distinctDao;

    public void loadAllFromDB() {
        loadProvince();
        loadCity();
        loadDistinct();
    }

    public void loadProvince() {
        List<ProvinceEntity> entityList = provinceDao.findProvinceByCriteria(new ProvinceCriteria(), null);
        if (entityList == null || entityList.size() == 0) {
            return;
        }
        for (ProvinceEntity entity : entityList) {
            provinceNameAndIdMap.put(buildKey(entity.getName()), entity.getId());
            provinceIdAndNameMap.put(entity.getId(), entity);
        }
    }

    public void loadCity() {
        List<CityEntity> cityList = cityDao.findCityByCriteria(new CityCriteria(), null);
        if (cityList == null) {
            return;
        }
        for (CityEntity entity : cityList) {
            if (!provinceIdAndNameMap.containsKey(entity.getProvinceId())) {
                log.warn("No province found for city: {}", entity);
                continue;
            }
            String provinceName = provinceIdAndNameMap.get(entity.getProvinceId()).getName();
            cityIdAndNameMap.put(entity.getId(), entity);
            cityNameAndIdMap.put(buildKey(provinceName ,entity.getName()), entity.getId());
        }
    }

    public void loadDistinct() {
        List<DistinctEntity> entityList = distinctDao.findDistinctByCriteria(new DistinctCriteria(), null);
        if (entityList == null) {
            return;
        }
        for (DistinctEntity entity : entityList) {
            if (!cityIdAndNameMap.containsKey(entity.getCityId())) {
                log.warn("No city found for distinct: {}", entity);
                continue;
            }
            distinctIdAndNameMap.put(entity.getId(), entity);
            distinctNameAndIdMap.put(buildKey(entity.getCityId(), entity.getName()), entity.getId());
        }
    }

    private String buildKey(String provinceName){
        return provinceName;
    }
    private String buildKey(String provinceName, String cityName){
        return provinceName+"-"+cityName;
    }
    private String buildKey(String provinceName, String cityName, String distinctName){
        return provinceName+"-"+cityName+"-"+distinctName;
    }
    public String findProvinceId(String provinceName){
        return provinceNameAndIdMap.get(buildKey(provinceName));
    }
    public String findCityId(String provinceName, String cityName){
        return cityNameAndIdMap.get(buildKey(provinceName,cityName));
    }
    public String findDistinctId(String cityId, String distinctName){
        return distinctNameAndIdMap.get(buildKey(cityId,distinctName));
    }
}
