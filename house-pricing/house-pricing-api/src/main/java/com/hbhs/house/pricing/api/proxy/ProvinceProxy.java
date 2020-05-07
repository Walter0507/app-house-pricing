package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.ProvinceClient;
import com.hbhs.house.pricing.api.endpoint.ProvinceEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProvinceProxy {
    @Autowired(required = false)
    @Qualifier(value = ProvinceEndpoint.API_NAME)
    private ProvinceEndpoint userEndpoint;

    @Autowired(required = false)
    private ProvinceClient userClient;

    public ProvinceEndpoint getProvinceEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
