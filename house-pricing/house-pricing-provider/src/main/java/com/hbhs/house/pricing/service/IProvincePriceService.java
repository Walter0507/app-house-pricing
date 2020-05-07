package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.ProvincePriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvincePriceInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface IProvincePriceService {

    ProvincePriceInfo createProvincePrice(ProvincePriceCreateParam param);

    Boolean updateProvincePrice(ProvincePriceUpdateParam param);

    Boolean deleteProvincePrice(String id);

    ProvincePriceInfo findProvincePriceById(String id);

    TPageResult<ProvincePriceInfo> queryProvincePrice(ProvincePriceQueryParam param, Pagination pagination);
}
