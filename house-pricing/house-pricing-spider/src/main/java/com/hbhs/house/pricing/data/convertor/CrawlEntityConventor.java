package com.hbhs.house.pricing.data.convertor;

import com.hbhs.common.tools.utils.DateUtil;
import com.hbhs.house.pricing.data.dto.CrawlCity;
import com.hbhs.house.pricing.data.dto.CrawlDistinct;
import com.hbhs.house.pricing.data.dto.CrawlDistinctPrice;
import com.hbhs.house.pricing.data.dto.CrawlProvince;
import com.hbhs.house.pricing.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrawlEntityConventor {
    @Autowired
    private LocalCacheService localCacheService;

    public List<ProvinceEntity> convertProvince(List<CrawlProvince> provinceList) {
        return provinceList.stream().map(province -> {
            ProvinceEntity entity = new ProvinceEntity();
            entity.setName(province.getProvinceName());
            entity.setSearchUrlLianjia(province.getCrawlUrl());
            return entity;
        }).collect(Collectors.toList());
    }

    public List<CityEntity> convertCity(List<CrawlCity> cityList) {
        return cityList.stream().map(city -> {
            CityEntity entity = new CityEntity();
            entity.setName(city.getCityName());
            entity.setProvinceId(localCacheService.findProvinceId(city.getProvinceName()));
            entity.setSearchUrlLianjia(city.getCrawlUrl());
            return entity;
        }).collect(Collectors.toList());
    }

    public List<DistinctEntity> convertDistinct(List<CrawlDistinct> distinctList){
        return distinctList.stream().map(distinct -> {
            DistinctEntity entity = new DistinctEntity();
            CityEntity cityEntity = localCacheService.getCityIdAndNameMap().get(distinct.getCityId());

            entity.setName(distinct.getDistinctName());
            entity.setSearchUrlLianjia(distinct.getCrawlUrl());
            if (cityEntity!=null){
                entity.setProvinceId(cityEntity.getProvinceId());
                entity.setCityId(cityEntity.getId());
            }

//            entity.setSearchUrlLianjia(distinct.getCrawlUrl());
            return entity;
        }).collect(Collectors.toList());
    }

    public List<DistinctPriceEntity> convertDistinctPrice(List<CrawlDistinctPrice> priceList){
        return priceList.stream().map(distinct -> {
            DistinctPriceEntity entity = new DistinctPriceEntity();
            DistinctEntity distinctEntity = localCacheService.getDistinctIdAndNameMap().get(distinct.getDistinctId());
            if (distinctEntity!=null){
                entity.setDistinctId(distinctEntity.getId());
                entity.setCityId(distinctEntity.getCityId());
                entity.setProvinceId(distinctEntity.getProvinceId());
            }

            entity.setLoadDay(new Date());
            entity.setWeek(DateUtil.week(new Date()));
            entity.setMonth(DateUtil.month(new Date()));

            entity.setSellingCount(distinct.getErshoufangCount().longValue());
            entity.setSellingAvgPrice(distinct.getAveragePrice().longValue());

            return entity;
        }).collect(Collectors.toList());
    }

    public List<CityPriceEntity> convertCityPrice(List<DistinctPriceEntity> distinctPriceEntityList){
        return distinctPriceEntityList.stream().map(object -> {
            CityPriceEntity entity = new CityPriceEntity();
            entity.setCityId(object.getCityId());
            entity.setSellingCount(object.getSellingCount());
            CityEntity cityEntity = localCacheService.getCityIdAndNameMap().get(object.getCityId());
            if (cityEntity!=null){

                entity.setProvinceId(cityEntity.getProvinceId());
            }

            entity.setLoadDay(DateUtil.day(new Date()));
            entity.setWeek(DateUtil.week(new Date()));
            entity.setMonth(DateUtil.month(new Date()));

            return entity;
        }).collect(Collectors.toList());
    }
}
