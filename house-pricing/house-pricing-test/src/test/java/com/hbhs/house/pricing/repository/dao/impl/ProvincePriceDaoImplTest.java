package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.IProvincePriceDao;
import com.hbhs.house.pricing.domain.entity.ProvincePriceEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProvincePriceDaoImplTest extends BaseDaoTest {

    @Autowired
    private IProvincePriceDao provincePriceDao;

    @Test
    public void testBasicFlow(){
        ProvincePriceEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = provincePriceDao.createProvincePrice(entity);
        Assert.assertTrue(result);

        entity = provincePriceDao.findProvincePriceById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = provincePriceDao.updateProvincePrice(entity);
        Assert.assertTrue(result);

        result = provincePriceDao.deletedProvincePrice(entity.getId());
        Assert.assertTrue(result);

        entity = provincePriceDao.findProvincePriceById(entity.getId());
        Assert.assertNull(entity);

        List<ProvincePriceEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = provincePriceDao.batchCreateProvincePrice(entityList);
        Assert.assertTrue(result);
    }

    private ProvincePriceEntity buildObject(long timestamp){
        return ProvincePriceEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
