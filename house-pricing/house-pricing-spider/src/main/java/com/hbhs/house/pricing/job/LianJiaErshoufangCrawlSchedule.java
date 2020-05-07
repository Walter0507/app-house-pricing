package com.hbhs.house.pricing.job;

import com.hbhs.house.pricing.data.LianJiaHousingLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LianJiaErshoufangCrawlSchedule {

    @Autowired
    private LianJiaHousingLoader loader;
    @Value("${crawl.address.lianjia.ershoufang.province:https://www.lianjia.com/city/}")
    private String lianjiaProvinceUrl;

    @Scheduled(cron = "0 0 1 ? * MON")
    public void loadBasicInfo(){
        loader.crawlAndSaveProvinceAndCity(lianjiaProvinceUrl);
        loader.crawlAndSaveDistinct();
    }

    @Scheduled(cron = "0 0 5 ? * MON")
    public void loadPricingData(){
        loader.crawlAndSaveDistinctPrice();
        loader.generateAndSaveCityPrice();
    }
}
