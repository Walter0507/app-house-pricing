package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.DistinctPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctPriceInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface IDistinctPriceService {

    DistinctPriceInfo createDistinctPrice(DistinctPriceCreateParam param);

    Boolean updateDistinctPrice(DistinctPriceUpdateParam param);

    Boolean deleteDistinctPrice(String id);

    DistinctPriceInfo findDistinctPriceById(String id);

    TPageResult<DistinctPriceInfo> queryDistinctPrice(DistinctPriceQueryParam param, Pagination pagination);
}
