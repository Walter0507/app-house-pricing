package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.CityClient;
import com.hbhs.house.pricing.api.endpoint.CityEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CityProxy {
    @Autowired(required = false)
    @Qualifier(value = CityEndpoint.API_NAME)
    private CityEndpoint userEndpoint;

    @Autowired(required = false)
    private CityClient userClient;

    public CityEndpoint getCityEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
