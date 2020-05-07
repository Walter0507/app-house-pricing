package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.CityPriceClient;
import com.hbhs.house.pricing.api.endpoint.CityPriceEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CityPriceProxy {
    @Autowired(required = false)
    @Qualifier(value = CityPriceEndpoint.API_NAME)
    private CityPriceEndpoint userEndpoint;

    @Autowired(required = false)
    private CityPriceClient userClient;

    public CityPriceEndpoint getCityPriceEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
