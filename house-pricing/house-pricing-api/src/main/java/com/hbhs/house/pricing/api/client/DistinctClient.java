package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.DistinctEndpoint;

//@FeignClient(name = "house-pricing", fallback = DistinctClientFallback.class)
public interface DistinctClient extends DistinctEndpoint {

}
