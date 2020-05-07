package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.DistinctPriceClient;
import com.hbhs.house.pricing.api.endpoint.DistinctPriceEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistinctPriceProxy {
    @Autowired(required = false)
    @Qualifier(value = DistinctPriceEndpoint.API_NAME)
    private DistinctPriceEndpoint userEndpoint;

    @Autowired(required = false)
    private DistinctPriceClient userClient;

    public DistinctPriceEndpoint getDistinctPriceEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
