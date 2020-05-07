package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.CityPriceEndpoint;
import com.hbhs.house.pricing.api.proxy.CityPriceProxy;
import com.hbhs.house.pricing.domain.request.param.CityPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityPriceInfo;
import com.hbhs.house.pricing.service.ICityPriceService;
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
@Service(value = CityPriceEndpoint.API_NAME)
@Slf4j
public class CityPriceController implements CityPriceEndpoint {
    @Autowired
    private ICityPriceService cityPriceService;
    @Override
    public TSingleResult<CityPriceInfo> create(GenericRequest<CityPriceCreateParam> request) {
        return TResultBuilder.succSingle(cityPriceService.createCityPrice(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<CityPriceUpdateParam> request) {
        return TResultBuilder.succSingle(cityPriceService.updateCityPrice(request.getParam()));
    }

    @Override
    public TSingleResult<CityPriceInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(cityPriceService.findCityPriceById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(cityPriceService.deleteCityPrice(request.getId()));
    }

    @Override
    public TPageResult<CityPriceInfo> queryCityPrice(QueryRequest<CityPriceQueryParam> request) {
        return cityPriceService.queryCityPrice(request.getParam(), request.getPagination());
    }
}
