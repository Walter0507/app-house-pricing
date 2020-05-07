package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.IGenerateLogDao;
import com.hbhs.house.pricing.domain.entity.GenerateLogEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GenerateLogDaoImplTest extends BaseDaoTest {

    @Autowired
    private IGenerateLogDao generateLogDao;

    @Test
    public void testBasicFlow(){
        GenerateLogEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = generateLogDao.createGenerateLog(entity);
        Assert.assertTrue(result);

        entity = generateLogDao.findGenerateLogById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = generateLogDao.updateGenerateLog(entity);
        Assert.assertTrue(result);

        result = generateLogDao.deletedGenerateLog(entity.getId());
        Assert.assertTrue(result);

        entity = generateLogDao.findGenerateLogById(entity.getId());
        Assert.assertNull(entity);

        List<GenerateLogEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = generateLogDao.batchCreateGenerateLog(entityList);
        Assert.assertTrue(result);
    }

    private GenerateLogEntity buildObject(long timestamp){
        return GenerateLogEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
