package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.DistinctPriceEndpoint;
import com.hbhs.house.pricing.api.proxy.DistinctPriceProxy;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctPriceInfo;
import com.hbhs.house.pricing.service.IDistinctPriceService;
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
@Service(value = DistinctPriceEndpoint.API_NAME)
@Slf4j
public class DistinctPriceController implements DistinctPriceEndpoint {
    @Autowired
    private IDistinctPriceService distinctPriceService;
    @Override
    public TSingleResult<DistinctPriceInfo> create(GenericRequest<DistinctPriceCreateParam> request) {
        return TResultBuilder.succSingle(distinctPriceService.createDistinctPrice(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<DistinctPriceUpdateParam> request) {
        return TResultBuilder.succSingle(distinctPriceService.updateDistinctPrice(request.getParam()));
    }

    @Override
    public TSingleResult<DistinctPriceInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(distinctPriceService.findDistinctPriceById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(distinctPriceService.deleteDistinctPrice(request.getId()));
    }

    @Override
    public TPageResult<DistinctPriceInfo> queryDistinctPrice(QueryRequest<DistinctPriceQueryParam> request) {
        return distinctPriceService.queryDistinctPrice(request.getParam(), request.getPagination());
    }
}
