package com.hbhs.house.pricing.data.dto;

import lombok.Data;

@Data
public class CrawlDistinct {
    private String provinceName;
    private String cityName;
    private String cityId;
    private String distinctName;
    private String crawlUrl;
}
