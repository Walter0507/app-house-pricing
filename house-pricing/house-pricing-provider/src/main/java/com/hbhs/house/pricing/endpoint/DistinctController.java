package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.DistinctEndpoint;
import com.hbhs.house.pricing.api.proxy.DistinctProxy;
import com.hbhs.house.pricing.domain.request.param.DistinctCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.house.pricing.service.IDistinctService;
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
@Service(value = DistinctEndpoint.API_NAME)
@Slf4j
public class DistinctController implements DistinctEndpoint {
    @Autowired
    private IDistinctService distinctService;
    @Override
    public TSingleResult<DistinctInfo> create(GenericRequest<DistinctCreateParam> request) {
        return TResultBuilder.succSingle(distinctService.createDistinct(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<DistinctUpdateParam> request) {
        return TResultBuilder.succSingle(distinctService.updateDistinct(request.getParam()));
    }

    @Override
    public TSingleResult<DistinctInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(distinctService.findDistinctById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(distinctService.deleteDistinct(request.getId()));
    }

    @Override
    public TPageResult<DistinctInfo> queryDistinct(QueryRequest<DistinctQueryParam> request) {
        return distinctService.queryDistinct(request.getParam(), request.getPagination());
    }
}
