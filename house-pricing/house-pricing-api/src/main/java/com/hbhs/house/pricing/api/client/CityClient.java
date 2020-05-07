package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.CityEndpoint;

//@FeignClient(name = "house-pricing", fallback = CityClientFallback.class)
public interface CityClient extends CityEndpoint {

}
