package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.CityEndpoint;
import com.hbhs.house.pricing.api.proxy.CityProxy;
import com.hbhs.house.pricing.domain.request.param.CityCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.house.pricing.service.ICityService;
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
@Service(value = CityEndpoint.API_NAME)
@Slf4j
public class CityController implements CityEndpoint {
    @Autowired
    private ICityService cityService;
    @Override
    public TSingleResult<CityInfo> create(GenericRequest<CityCreateParam> request) {
        return TResultBuilder.succSingle(cityService.createCity(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<CityUpdateParam> request) {
        return TResultBuilder.succSingle(cityService.updateCity(request.getParam()));
    }

    @Override
    public TSingleResult<CityInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(cityService.findCityById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(cityService.deleteCity(request.getId()));
    }

    @Override
    public TPageResult<CityInfo> queryCity(QueryRequest<CityQueryParam> request) {
        return cityService.queryCity(request.getParam(), request.getPagination());
    }
}
