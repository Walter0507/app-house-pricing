package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.IDistinctDao;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DistinctDaoImplTest extends BaseDaoTest {

    @Autowired
    private IDistinctDao distinctDao;

    @Test
    public void testBasicFlow(){
        DistinctEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = distinctDao.createDistinct(entity);
        Assert.assertTrue(result);

        entity = distinctDao.findDistinctById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = distinctDao.updateDistinct(entity);
        Assert.assertTrue(result);

        result = distinctDao.deletedDistinct(entity.getId());
        Assert.assertTrue(result);

        entity = distinctDao.findDistinctById(entity.getId());
        Assert.assertNull(entity);

        List<DistinctEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = distinctDao.batchCreateDistinct(entityList);
        Assert.assertTrue(result);
    }

    private DistinctEntity buildObject(long timestamp){
        return DistinctEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
