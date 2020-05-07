package com.hbhs.house.pricing.controller;

import com.hbhs.common.domain.model.response.TMultiResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.house.pricing.domain.response.info.ProvinceAndCityInfo;
import com.hbhs.house.pricing.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/province_and_city")
    public TMultiResult<ProvinceAndCityInfo> findProvinceList() {
        return TResultBuilder.succMulti(locationService.findAllProvinceAndCity());
    }

    @RequestMapping("/distinct")
    public TMultiResult<DistinctInfo> findDistinctByCity(@RequestParam("cityId") String cityId) {
        return TResultBuilder.succMulti(locationService.findDistinctInfoByCityId(cityId));
    }

}
