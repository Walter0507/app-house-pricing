package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.DistinctCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface IDistinctService {

    DistinctInfo createDistinct(DistinctCreateParam param);

    Boolean updateDistinct(DistinctUpdateParam param);

    Boolean deleteDistinct(String id);

    DistinctInfo findDistinctById(String id);

    TPageResult<DistinctInfo> queryDistinct(DistinctQueryParam param, Pagination pagination);
}
