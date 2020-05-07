package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.ProvinceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface IProvinceService {

    ProvinceInfo createProvince(ProvinceCreateParam param);

    Boolean updateProvince(ProvinceUpdateParam param);

    Boolean deleteProvince(String id);

    ProvinceInfo findProvinceById(String id);

    TPageResult<ProvinceInfo> queryProvince(ProvinceQueryParam param, Pagination pagination);
}
