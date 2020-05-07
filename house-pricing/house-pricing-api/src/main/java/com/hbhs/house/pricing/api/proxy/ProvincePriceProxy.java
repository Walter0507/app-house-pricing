package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.ProvincePriceClient;
import com.hbhs.house.pricing.api.endpoint.ProvincePriceEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProvincePriceProxy {
    @Autowired(required = false)
    @Qualifier(value = ProvincePriceEndpoint.API_NAME)
    private ProvincePriceEndpoint userEndpoint;

    @Autowired(required = false)
    private ProvincePriceClient userClient;

    public ProvincePriceEndpoint getProvincePriceEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
