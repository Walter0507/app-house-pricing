package com.hbhs.house.pricing.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class CrawlDistinctPrice {
    private String distinctId;
    private Integer ershoufangCount;
    private Integer averagePrice;
}
