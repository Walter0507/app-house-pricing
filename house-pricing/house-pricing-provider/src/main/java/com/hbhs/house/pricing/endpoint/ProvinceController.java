package com.hbhs.house.pricing.endpoint;

import com.hbhs.house.pricing.api.endpoint.ProvinceEndpoint;
import com.hbhs.house.pricing.api.proxy.ProvinceProxy;
import com.hbhs.house.pricing.domain.request.param.ProvinceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import com.hbhs.house.pricing.service.IProvinceService;
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
@Service(value = ProvinceEndpoint.API_NAME)
@Slf4j
public class ProvinceController implements ProvinceEndpoint {
    @Autowired
    private IProvinceService provinceService;
    @Override
    public TSingleResult<ProvinceInfo> create(GenericRequest<ProvinceCreateParam> request) {
        return TResultBuilder.succSingle(provinceService.createProvince(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<ProvinceUpdateParam> request) {
        return TResultBuilder.succSingle(provinceService.updateProvince(request.getParam()));
    }

    @Override
    public TSingleResult<ProvinceInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(provinceService.findProvinceById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(provinceService.deleteProvince(request.getId()));
    }

    @Override
    public TPageResult<ProvinceInfo> queryProvince(QueryRequest<ProvinceQueryParam> request) {
        return provinceService.queryProvince(request.getParam(), request.getPagination());
    }
}
