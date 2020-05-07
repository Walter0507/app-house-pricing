package com.hbhs.house.pricing.domain.response.info;

import lombok.Data;

import java.util.List;

@Data
public class ProvinceAndCityInfo {
    private String provinceId;
    private String provinceName;
    private List<CityInfo> cityList;
}
