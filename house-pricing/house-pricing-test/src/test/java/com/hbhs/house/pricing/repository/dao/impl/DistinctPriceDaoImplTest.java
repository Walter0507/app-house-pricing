package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.IDistinctPriceDao;
import com.hbhs.house.pricing.domain.entity.DistinctPriceEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DistinctPriceDaoImplTest extends BaseDaoTest {

    @Autowired
    private IDistinctPriceDao distinctPriceDao;

    @Test
    public void testBasicFlow(){
        DistinctPriceEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = distinctPriceDao.createDistinctPrice(entity);
        Assert.assertTrue(result);

        entity = distinctPriceDao.findDistinctPriceById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = distinctPriceDao.updateDistinctPrice(entity);
        Assert.assertTrue(result);

        result = distinctPriceDao.deletedDistinctPrice(entity.getId());
        Assert.assertTrue(result);

        entity = distinctPriceDao.findDistinctPriceById(entity.getId());
        Assert.assertNull(entity);

        List<DistinctPriceEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = distinctPriceDao.batchCreateDistinctPrice(entityList);
        Assert.assertTrue(result);
    }

    private DistinctPriceEntity buildObject(long timestamp){
        return DistinctPriceEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
