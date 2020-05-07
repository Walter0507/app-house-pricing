package com.hbhs.house.pricing.data.spider.distinct;

import com.hbhs.house.pricing.data.spider.HousingCrawler;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import us.codecraft.webmagic.Spider;

import java.util.*;

/**
 * @author juqi
 * @date 2019/1/3 11:19
 **/
@Slf4j
public class LianJiaDistinctPricePageCrawler implements HousingCrawler {

    private volatile Spider spider;
    @Getter
    private DistinctEntity entity;
    @Getter@Setter
    private Integer totalErshoufangCount = -1;
    @Getter@Setter
    private List<Integer> priceList = new ArrayList<>();
    @Getter@Setter
    private Set<String> crawlUrlList = new HashSet<>();

    public LianJiaDistinctPricePageCrawler setDistinctEntity(DistinctEntity entity){
        this.entity = entity;
        priceList.clear();
        crawlUrlList.clear();
        return this;
    }

    public void clear(){
        this.entity = null;
        priceList.clear();
        crawlUrlList.clear();
    }
    @Override
    public void init() {
        initSpiderIfNull();
    }

    private void initSpiderIfNull(){
        if (spider == null){
            synchronized (this){
                if (spider==null){
                    spider = Spider.create(new LianJiaDistinctPricePageProcess(this))
                            .thread(2);
                }
            }
        }
    }

    @Override
    public void crawlPage(List<String> urlList) {
        initSpiderIfNull();
        Assert.notNull(entity, "Field 'entity' cannot be null");
        spider.startUrls(Collections.singletonList(entity.getSearchUrlLianjia()))
                .run();
    }

    @Override
    public void close() {
        if (spider!=null){
            spider.close();
        }
    }

    public int averagePrice(){
        if (priceList.size()==0){return 0;}
        return priceList.stream().mapToInt(Integer::intValue).sum()/priceList.size();
    }

}
