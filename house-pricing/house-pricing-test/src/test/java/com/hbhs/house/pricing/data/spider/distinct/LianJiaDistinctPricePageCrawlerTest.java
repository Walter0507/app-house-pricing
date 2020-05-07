package com.hbhs.house.pricing.data.spider.distinct;

import com.hbhs.house.pricing.domain.entity.DistinctEntity;

import static org.junit.Assert.*;

public class LianJiaDistinctPricePageCrawlerTest {

    public static void main(String[] args) {
        LianJiaDistinctPricePageCrawler crawler = new LianJiaDistinctPricePageCrawler();
        DistinctEntity entity = new DistinctEntity();
        entity.setSearchUrlLianjia("https://hf.lianjia.com/ershoufang/chaohushi/");
        crawler.setDistinctEntity(entity);
        crawler.crawlPage(null);
        crawler.close();
    }
}