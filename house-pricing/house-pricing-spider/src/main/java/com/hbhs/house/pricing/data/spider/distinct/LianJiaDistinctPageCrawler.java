package com.hbhs.house.pricing.data.spider.distinct;

import com.hbhs.house.pricing.data.dto.CrawlCityPrice;
import com.hbhs.house.pricing.data.dto.CrawlDistinct;
import com.hbhs.house.pricing.data.dto.CrawlDistinctPrice;
import com.hbhs.house.pricing.data.spider.HousingCrawler;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author juqi
 * @date 2019/1/3 11:19
 **/
public class LianJiaDistinctPageCrawler implements HousingCrawler {
    private static final Logger LOG = LoggerFactory.getLogger(LianJiaDistinctPageCrawler.class);

    private volatile Spider spider;
    @Getter
    private CityEntity city;
    @Getter@Setter
    private Integer totalErshoufangCount ;
    @Getter
    private List<CrawlDistinct> distinctList = new ArrayList<>();

    public LianJiaDistinctPageCrawler(){

    }

    public LianJiaDistinctPageCrawler setCityEntity(CityEntity city){
        this.city = city;
        return this;
    }

    @Override
    public void init() {
        initSpiderIfNull();
    }

    private void initSpiderIfNull(){
        if (spider == null){
            synchronized (this){
                if (spider==null){
                    spider = Spider.create(new LianJiaDistinctPageProcess(this))
                            .thread(1);
                }
            }
        }
    }

    @Override
    public void crawlPage(List<String> urlList) {
        initSpiderIfNull();
        spider.startUrls(Collections.singletonList(city.getSearchUrlLianjia()))
                .run();
    }


    @Override
    public void close() {
        if (spider!=null){
            spider.close();
        }
    }

}
