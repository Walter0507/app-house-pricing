package com.hbhs.house.pricing.data.service;

import com.hbhs.common.tools.id.mongodb.ObjectId;
import com.hbhs.common.tools.utils.DateUtil;
import com.hbhs.house.pricing.data.convertor.CrawlEntityConventor;
import com.hbhs.house.pricing.data.convertor.LocalCacheService;
import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.repository.dao.ICityPriceDao;
import com.hbhs.house.pricing.repository.dao.IDistinctPriceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class CityPriceLoaderProxy {
    @Autowired
    private LocalCacheService localCacheService;
    @Autowired
    private CrawlEntityConventor entityConventor;
    @Autowired
    private ICityPriceDao cityDao;
    @Autowired
    private IDistinctPriceDao distinctPriceDao;

    public void loadAndGenerateCityPrice(){
        Date startWeek = DateUtil.week(new Date(),1);
        Date endWeek = DateUtil.week(new Date(),7);
        List<DistinctPriceEntity> priceEntityList = distinctPriceDao.findCityPriceSummaryGroupByCityId(null,null,
                startWeek , endWeek);
        cityDao.deleteCityPrice(null, null,startWeek,endWeek);
        List<CityPriceEntity> list = entityConventor.convertCityPrice(priceEntityList);
        if (list!=null&&list.size()>0){
            for (CityPriceEntity entity : list) {
                entity.setId(ObjectId.get().toString());
                cityDao.createCityPrice(entity);
            }
        }
    }

}
