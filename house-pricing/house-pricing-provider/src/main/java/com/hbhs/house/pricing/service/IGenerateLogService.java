package com.hbhs.house.pricing.service;

import com.hbhs.house.pricing.domain.request.param.GenerateLogCreateParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogQueryParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogUpdateParam;
import com.hbhs.house.pricing.domain.response.info.GenerateLogInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface IGenerateLogService {

    GenerateLogInfo createGenerateLog(GenerateLogCreateParam param);

    Boolean updateGenerateLog(GenerateLogUpdateParam param);

    Boolean deleteGenerateLog(String id);

    GenerateLogInfo findGenerateLogById(String id);

    TPageResult<GenerateLogInfo> queryGenerateLog(GenerateLogQueryParam param, Pagination pagination);
}
