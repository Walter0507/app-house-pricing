package com.hbhs.house.pricing.api.proxy;

import com.hbhs.house.pricing.api.client.GenerateLogClient;
import com.hbhs.house.pricing.api.endpoint.GenerateLogEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenerateLogProxy {
    @Autowired(required = false)
    @Qualifier(value = GenerateLogEndpoint.API_NAME)
    private GenerateLogEndpoint userEndpoint;

    @Autowired(required = false)
    private GenerateLogClient userClient;

    public GenerateLogEndpoint getGenerateLogEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
