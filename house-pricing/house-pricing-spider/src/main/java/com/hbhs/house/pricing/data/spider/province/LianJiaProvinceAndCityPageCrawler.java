package com.hbhs.house.pricing.data.spider.province;

import com.hbhs.house.pricing.data.dto.CrawlCity;
import com.hbhs.house.pricing.data.dto.CrawlProvince;
import com.hbhs.house.pricing.data.spider.HousingCrawler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juqi
 * @date 2018/12/26 16:35
 **/
@Slf4j
public class LianJiaProvinceAndCityPageCrawler implements HousingCrawler {

    private volatile Spider spider;

    @Getter
    private List<CrawlProvince> provinceList = new ArrayList<>();
    @Getter
    private List<CrawlCity> cityList = new ArrayList<>();

    @Override
    public void init() {
        initSpiderIfNull();
    }

    private void initSpiderIfNull(){
        if (spider == null){
            synchronized (this){
                if (spider==null){
                    spider = Spider.create(new LianJiaProvinceAndCityPageProcess(this))
                            .thread(1);
                }
            }
        }
    }

    @Override
    public void crawlPage(List<String> urlList) {
        if (CollectionUtils.isNotEmpty(urlList)){
            initSpiderIfNull();
            spider.startUrls(urlList)
                    .run();
        }
    }

    @Override
    public void close() {
        if (spider!=null){
            spider.close();
        }
    }

}
