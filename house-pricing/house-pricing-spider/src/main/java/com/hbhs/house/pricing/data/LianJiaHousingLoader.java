package com.hbhs.house.pricing.data;

import com.hbhs.common.tools.utils.DateUtil;
import com.hbhs.house.pricing.data.convertor.LocalCacheService;
import com.hbhs.house.pricing.data.dto.CrawlDistinctPrice;
import com.hbhs.house.pricing.data.service.*;
import com.hbhs.house.pricing.data.spider.distinct.LianJiaDistinctPageCrawler;
import com.hbhs.house.pricing.data.spider.distinct.LianJiaDistinctPricePageCrawler;
import com.hbhs.house.pricing.data.spider.province.LianJiaProvinceAndCityPageCrawler;
import com.hbhs.house.pricing.domain.criteria.CityCriteria;
import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.criteria.DistinctPriceCriteria;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.repository.dao.IDistinctDao;
import com.hbhs.house.pricing.repository.dao.IDistinctPriceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class LianJiaHousingLoader {

    @Autowired
    private LocalCacheService localCacheService;
    @Autowired
    private ProvinceLoaderProxy provinceLoaderProxy;
    @Autowired
    private CityLoaderProxy cityLoaderProxy;
    @Autowired
    private DistinctLoaderProxy distinctLoaderProxy;
    @Autowired
    private DistinctPriceDamProxy distinctPriceDamProxy;
    @Autowired
    private CityPriceLoaderProxy cityPriceLoaderProxy;

    @Autowired
    private ICityDao cityDao;
    @Autowired
    private IDistinctDao distinctDao;
    @Autowired
    private IDistinctPriceDao distinctPriceDao;


    public void crawlAndSaveProvinceAndCity(String url){
        LianJiaProvinceAndCityPageCrawler crawler = new LianJiaProvinceAndCityPageCrawler();
        crawler.init();
        crawler.crawlPage(Collections.singletonList(url));
        crawler.close();
        localCacheService.loadProvince();
        provinceLoaderProxy.saveProvince(crawler.getProvinceList());
        localCacheService.loadProvince();

        localCacheService.loadCity();
        cityLoaderProxy.saveCity(crawler.getCityList());
    }

    public void crawlAndSaveDistinct(){
        localCacheService.loadAllFromDB();

        List<CityEntity> cityEntityList = cityDao.findCityByCriteria(new CityCriteria(), null);
        LianJiaDistinctPageCrawler crawler = new LianJiaDistinctPageCrawler();
        crawler.init();
        for (CityEntity cityEntity : cityEntityList) {
            crawler.setCityEntity(cityEntity).crawlPage(null);

            distinctLoaderProxy.saveDistinct(crawler.getDistinctList());
            crawler.getDistinctList().clear();
            localCacheService.loadDistinct();
        }
        crawler.close();
    }

    public void crawlAndSaveDistinctPrice(){
        localCacheService.loadAllFromDB();
        List<DistinctEntity> list = distinctDao.findDistinctByCriteria(new DistinctCriteria(), null);
        if (list==null||list.size()==0){
            return ;
        }
        Set<String> loadedDistinctIdSet = findLoadedDistinctIdOfThisWeek();
        list.removeIf(entity-> loadedDistinctIdSet.contains(entity.getId()));
        if (list.size()==0){
            return ;
        }
        LianJiaDistinctPricePageCrawler crawler = new LianJiaDistinctPricePageCrawler();
        crawler.init();
        for (DistinctEntity entity : list) {
            crawler.setDistinctEntity(entity).crawlPage(null);

            distinctPriceDamProxy.saveCityPriceWithDam(new CrawlDistinctPrice(entity.getId(), crawler.getTotalErshoufangCount(),crawler.averagePrice()));
        }
        crawler.close();

    }

    public void generateAndSaveCityPrice(){
        localCacheService.loadAllFromDB();
        cityPriceLoaderProxy.loadAndGenerateCityPrice();
    }

    private Set<String> findLoadedDistinctIdOfThisWeek(){
        DistinctPriceCriteria criteria = new DistinctPriceCriteria();

        criteria.setStartWeek(DateUtil.week(new Date(), 0));
        criteria.setEndWeek(DateUtil.week(new Date(), 7));

        List<DistinctPriceEntity> list = distinctPriceDao.findDistinctPriceByCriteria(criteria, null);
        if (list==null){
            return Collections.emptySet();
        }
        return list.stream().filter(entity->entity.getSellingCount()>=0).map(DistinctPriceEntity::getDistinctId).collect(Collectors.toSet());
    }
}
