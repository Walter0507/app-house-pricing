package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.GenerateLogEndpoint;

//@FeignClient(name = "house-pricing", fallback = GenerateLogClientFallback.class)
public interface GenerateLogClient extends GenerateLogEndpoint {

}
