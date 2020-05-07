package com.hbhs.house.pricing.data.service;

import com.hbhs.common.dam.DamByBatchProcessor;
import com.hbhs.house.pricing.data.dto.CrawlCityPrice;
import com.hbhs.house.pricing.data.dto.CrawlDistinctPrice;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DistinctPriceDamHandler implements DamByBatchProcessor.BatchEventHandler<CrawlDistinctPrice> {
    private DistinctPriceDamProxy proxy;

    @Override
    public boolean handler(List<CrawlDistinctPrice> requestList) {
        return proxy.saveDistinctPrice(requestList);
    }
}
