package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.DistinctClient;
import com.hbhs.house.pricing.api.endpoint.DistinctEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistinctProxy {
    @Autowired(required = false)
    @Qualifier(value = DistinctEndpoint.API_NAME)
    private DistinctEndpoint userEndpoint;

    @Autowired(required = false)
    private DistinctClient userClient;

    public DistinctEndpoint getDistinctEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
