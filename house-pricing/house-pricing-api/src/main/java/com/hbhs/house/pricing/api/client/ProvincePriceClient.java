package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.ProvincePriceEndpoint;

//@FeignClient(name = "house-pricing", fallback = ProvincePriceClientFallback.class)
public interface ProvincePriceClient extends ProvincePriceEndpoint {

}
