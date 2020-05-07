package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.domain.entity.CityEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImplTest extends BaseDaoTest {

    @Autowired
    private ICityDao cityDao;

    @Test
    public void testBasicFlow(){
        CityEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = cityDao.createCity(entity);
        Assert.assertTrue(result);

        entity = cityDao.findCityById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = cityDao.updateCity(entity);
        Assert.assertTrue(result);

        result = cityDao.deletedCity(entity.getId());
        Assert.assertTrue(result);

        entity = cityDao.findCityById(entity.getId());
        Assert.assertNull(entity);

        List<CityEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = cityDao.batchCreateCity(entityList);
        Assert.assertTrue(result);
    }

    private CityEntity buildObject(long timestamp){
        return CityEntity.builder()
                .id(timestamp+"")
                .name("")
                .build();
    }

}
