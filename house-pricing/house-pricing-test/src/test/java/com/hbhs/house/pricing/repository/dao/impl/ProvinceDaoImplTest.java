package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.BaseDaoTest;
import com.hbhs.house.pricing.repository.dao.IProvinceDao;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImplTest extends BaseDaoTest {

    @Autowired
    private IProvinceDao provinceDao;

    @Test
    public void testBasicFlow(){
        ProvinceEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = provinceDao.createProvince(entity);
        Assert.assertTrue(result);

        entity = provinceDao.findProvinceById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = provinceDao.updateProvince(entity);
        Assert.assertTrue(result);

        result = provinceDao.deletedProvince(entity.getId());
        Assert.assertTrue(result);

        entity = provinceDao.findProvinceById(entity.getId());
        Assert.assertNull(entity);

        List<ProvinceEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = provinceDao.batchCreateProvince(entityList);
        Assert.assertTrue(result);
    }

    private ProvinceEntity buildObject(long timestamp){
        return ProvinceEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
