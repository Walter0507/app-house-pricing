package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.CityCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface ICityService {

    CityInfo createCity(CityCreateParam param);

    Boolean updateCity(CityUpdateParam param);

    Boolean deleteCity(String id);

    CityInfo findCityById(String id);

    TPageResult<CityInfo> queryCity(CityQueryParam param, Pagination pagination);
}
