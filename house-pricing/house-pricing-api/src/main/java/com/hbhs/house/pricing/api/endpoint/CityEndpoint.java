package com.hbhs.house.pricing.api.endpoint;

import com.hbhs.house.pricing.domain.request.param.CityCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityQueryParam;
import com.hbhs.house.pricing.domain.request.param.CityUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CityEndpoint {
    static final String API_NAME = "CityEndpoint";
    static final String VERSION = "/endpoint/v1";

    @RequestMapping(value = VERSION+"/user/create", method = RequestMethod.POST)
    TSingleResult<CityInfo> create(@RequestBody GenericRequest<CityCreateParam> request);

    @RequestMapping(value = VERSION+"/user/update", method = RequestMethod.POST)
    TSingleResult<Boolean> udpate(@RequestBody GenericRequest<CityUpdateParam> request);

    @RequestMapping(value = VERSION+"/user/find_by_id", method = RequestMethod.POST)
    TSingleResult<CityInfo> findById(@RequestBody IdRequest request);

    @RequestMapping(value = VERSION+"/user/delete_by_id", method = RequestMethod.POST)
    TSingleResult<Boolean> deleteById(@RequestBody IdRequest request);

    @RequestMapping(value = VERSION+"/user/query", method = RequestMethod.POST)
    TPageResult<CityInfo> queryCity(@RequestBody QueryRequest<CityQueryParam> request);
}
