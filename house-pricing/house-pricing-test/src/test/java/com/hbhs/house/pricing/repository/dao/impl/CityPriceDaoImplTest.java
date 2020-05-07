package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.ICityPriceDao;
import com.hbhs.house.pricing.domain.entity.CityPriceEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CityPriceDaoImplTest extends BaseDaoTest {

    @Autowired
    private ICityPriceDao cityPriceDao;

    @Test
    public void testBasicFlow(){
        CityPriceEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = cityPriceDao.createCityPrice(entity);
        Assert.assertTrue(result);

        entity = cityPriceDao.findCityPriceById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = cityPriceDao.updateCityPrice(entity);
        Assert.assertTrue(result);

        result = cityPriceDao.deletedCityPrice(entity.getId());
        Assert.assertTrue(result);

        entity = cityPriceDao.findCityPriceById(entity.getId());
        Assert.assertNull(entity);

        List<CityPriceEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = cityPriceDao.batchCreateCityPrice(entityList);
        Assert.assertTrue(result);
    }

    private CityPriceEntity buildObject(long timestamp){
        return CityPriceEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
