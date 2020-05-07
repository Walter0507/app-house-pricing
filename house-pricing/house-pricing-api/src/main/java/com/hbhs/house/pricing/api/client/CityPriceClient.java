package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.CityPriceEndpoint;

//@FeignClient(name = "house-pricing", fallback = CityPriceClientFallback.class)
public interface CityPriceClient extends CityPriceEndpoint {

}
