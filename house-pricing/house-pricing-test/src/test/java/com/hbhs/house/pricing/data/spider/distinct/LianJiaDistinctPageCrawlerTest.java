package com.hbhs.house.pricing.data.spider.distinct;

import com.hbhs.house.pricing.data.dto.CrawlCityPrice;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class LianJiaDistinctPageCrawlerTest {
    @Test
    public void crawl(){
        CrawlCityPrice entity = new CrawlCityPrice();
        LianJiaDistinctPageCrawler crawler = new LianJiaDistinctPageCrawler();
        crawler.setCityEntity(new CityEntity());
        crawler.init();
        crawler.crawlPage(Collections.singletonList("https://xm.lianjia.com/ershoufang/"));
        crawler.close();
        System.out.println(crawler.getCity());
    }
}