package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.endpoint.ProvinceEndpoint;

//@FeignClient(name = "house-pricing", fallback = ProvinceClientFallback.class)
public interface ProvinceClient extends ProvinceEndpoint {

}
