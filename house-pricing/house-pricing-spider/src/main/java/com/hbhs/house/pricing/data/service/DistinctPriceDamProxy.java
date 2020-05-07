package com.hbhs.house.pricing.data.service;

import com.hbhs.common.dam.DamByBatchProcessor;
import com.hbhs.common.tools.id.mongodb.ObjectId;
import com.hbhs.house.pricing.data.convertor.CrawlEntityConventor;
import com.hbhs.house.pricing.data.convertor.LocalCacheService;
import com.hbhs.house.pricing.data.dto.CrawlCityPrice;
import com.hbhs.house.pricing.data.dto.CrawlDistinctPrice;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import com.hbhs.house.pricing.repository.dao.ICityPriceDao;
import com.hbhs.house.pricing.repository.dao.IDistinctPriceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DistinctPriceDamProxy {
    private DamByBatchProcessor damProcessor = new DamByBatchProcessor(5, new DistinctPriceDamHandler(this));
    @Autowired
    private LocalCacheService cacheService;
    @Autowired
    private IDistinctPriceDao distinctPriceDao;
    @Autowired
    private CrawlEntityConventor entityConventor;

    public void saveCityPriceWithDam(CrawlDistinctPrice cityPrice){
        if (cityPrice==null||cityPrice.getErshoufangCount()==null||cityPrice.getErshoufangCount()<0){
            return ;
        }
        damProcessor.process(cityPrice);
    }

    public void flush(){
        damProcessor.flush();
    }

    boolean saveDistinctPrice(List<CrawlDistinctPrice> priceList){
        if (priceList!=null){
            List<DistinctPriceEntity> entityList = entityConventor.convertDistinctPrice(priceList);
            for (DistinctPriceEntity distinctPriceEntity : entityList) {
                distinctPriceEntity.setId(ObjectId.get().toString());
                distinctPriceDao.createDistinctPrice(distinctPriceEntity);
            }
        }
        return Boolean.TRUE;
    }

}
