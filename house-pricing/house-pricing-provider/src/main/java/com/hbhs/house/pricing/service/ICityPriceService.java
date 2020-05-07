package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.CityPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityPriceInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface ICityPriceService {

    CityPriceInfo createCityPrice(CityPriceCreateParam param);

    Boolean updateCityPrice(CityPriceUpdateParam param);

    Boolean deleteCityPrice(String id);

    CityPriceInfo findCityPriceById(String id);

    TPageResult<CityPriceInfo> queryCityPrice(CityPriceQueryParam param, Pagination pagination);
}
