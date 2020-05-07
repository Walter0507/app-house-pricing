package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.GenerateLogEndpoint;
import com.hbhs.house.pricing.api.proxy.GenerateLogProxy;
import com.hbhs.house.pricing.domain.request.param.GenerateLogCreateParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogQueryParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogUpdateParam;
import com.hbhs.house.pricing.domain.response.info.GenerateLogInfo;
import com.hbhs.house.pricing.service.IGenerateLogService;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service(value = GenerateLogEndpoint.API_NAME)
@Slf4j
public class GenerateLogController implements GenerateLogEndpoint {
    @Autowired
    private IGenerateLogService generateLogService;
    @Override
    public TSingleResult<GenerateLogInfo> create(GenericRequest<GenerateLogCreateParam> request) {
        return TResultBuilder.succSingle(generateLogService.createGenerateLog(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<GenerateLogUpdateParam> request) {
        return TResultBuilder.succSingle(generateLogService.updateGenerateLog(request.getParam()));
    }

    @Override
    public TSingleResult<GenerateLogInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(generateLogService.findGenerateLogById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(generateLogService.deleteGenerateLog(request.getId()));
    }

    @Override
    public TPageResult<GenerateLogInfo> queryGenerateLog(QueryRequest<GenerateLogQueryParam> request) {
        return generateLogService.queryGenerateLog(request.getParam(), request.getPagination());
    }
}
