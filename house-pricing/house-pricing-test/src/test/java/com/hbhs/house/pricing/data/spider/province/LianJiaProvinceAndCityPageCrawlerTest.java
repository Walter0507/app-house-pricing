package com.hbhs.house.pricing.data.spider.province;

import org.junit.Test;

import java.util.Collections;

public class LianJiaProvinceAndCityPageCrawlerTest {

    @Test
    public void crawl(){
        LianJiaProvinceAndCityPageCrawler crawler = new LianJiaProvinceAndCityPageCrawler();
        crawler.init();
        crawler.crawlPage(Collections.singletonList("https://www.lianjia.com/city/"));
        System.out.println(crawler.getCityList());
        System.out.println(crawler.getProvinceList());
    }
}