package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.ProvincePriceEndpoint;
import com.hbhs.house.pricing.api.proxy.ProvincePriceProxy;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvincePriceInfo;
import com.hbhs.house.pricing.service.IProvincePriceService;
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
@Service(value = ProvincePriceEndpoint.API_NAME)
@Slf4j
public class ProvincePriceController implements ProvincePriceEndpoint {
    @Autowired
    private IProvincePriceService provincePriceService;
    @Override
    public TSingleResult<ProvincePriceInfo> create(GenericRequest<ProvincePriceCreateParam> request) {
        return TResultBuilder.succSingle(provincePriceService.createProvincePrice(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<ProvincePriceUpdateParam> request) {
        return TResultBuilder.succSingle(provincePriceService.updateProvincePrice(request.getParam()));
    }

    @Override
    public TSingleResult<ProvincePriceInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(provincePriceService.findProvincePriceById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(provincePriceService.deleteProvincePrice(request.getId()));
    }

    @Override
    public TPageResult<ProvincePriceInfo> queryProvincePrice(QueryRequest<ProvincePriceQueryParam> request) {
        return provincePriceService.queryProvincePrice(request.getParam(), request.getPagination());
    }
}
