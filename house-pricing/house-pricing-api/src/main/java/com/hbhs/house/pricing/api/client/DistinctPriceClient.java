package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.DistinctPriceEndpoint;

//@FeignClient(name = "house-pricing", fallback = DistinctPriceClientFallback.class)
public interface DistinctPriceClient extends DistinctPriceEndpoint {

}
