package com.hbhs.house.pricing.service;

import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.house.pricing.domain.request.param.CityQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceQueryParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.house.pricing.domain.response.info.ProvinceAndCityInfo;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LocationService {

    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private ICityService cityService;
    @Autowired
    private IDistinctService distinctService;

    public List<ProvinceAndCityInfo> findAllProvinceAndCity(){
        TPageResult<ProvinceInfo> provinceInfoResult = provinceService.queryProvince(new ProvinceQueryParam(), new Pagination());
        TPageResult<CityInfo> cityInfoResult = cityService.queryCity(new CityQueryParam(), new Pagination());
        return buildProvinceAndCityInfo(provinceInfoResult.getData(), cityInfoResult.getData());
    }

    private List<ProvinceAndCityInfo> buildProvinceAndCityInfo(List<ProvinceInfo> provinceInfos, List<CityInfo> cityInfos){
        List<ProvinceAndCityInfo> resultList = new ArrayList<>();
        Map<String, ProvinceAndCityInfo> resultMap = new HashMap<>();
        if (provinceInfos!=null){
            provinceInfos.forEach(provinceInfo -> {
                ProvinceAndCityInfo info = new ProvinceAndCityInfo();
                info.setProvinceId(provinceInfo.getId());
                info.setProvinceName(provinceInfo.getName());
                info.setCityList(new ArrayList<>());
                resultList.add(info);
                resultMap.put(info.getProvinceId(), info);
            });
        }

        if (cityInfos!=null){
            cityInfos.forEach(cityInfo -> {
                if (resultMap.get(cityInfo.getProvinceId())!=null){
                    resultMap.get(cityInfo.getProvinceId()).getCityList().add(cityInfo);
                }
            });
        }
        return resultList;
    }

    public List<DistinctInfo> findDistinctInfoByCityId(String cityId){
        DistinctQueryParam param = new DistinctQueryParam();
        param.setCityId(cityId);
        TPageResult<DistinctInfo> distinctInfoResult = distinctService.queryDistinct(param, new Pagination());
        return distinctInfoResult.getData();
    }
}
