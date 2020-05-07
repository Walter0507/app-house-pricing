package com.hbhs.house.pricing.data.service;

import com.hbhs.common.dam.DamByBatchProcessor;
import com.hbhs.common.tools.id.mongodb.ObjectId;
import com.hbhs.house.pricing.data.convertor.CrawlEntityConventor;
import com.hbhs.house.pricing.data.convertor.LocalCacheService;
import com.hbhs.house.pricing.data.dto.CrawlProvince;
import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.house.pricing.repository.dao.ICityDao;
import com.hbhs.house.pricing.repository.dao.IProvinceDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProvinceLoaderProxy {
    @Autowired
    private IProvinceDao provinceDao;
    @Autowired
    private CrawlEntityConventor conventor;
    @Autowired
    private LocalCacheService localCacheService;

    public void saveProvince(List<CrawlProvince> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.removeIf(entity->localCacheService.getProvinceNameAndIdMap().containsKey(entity.getProvinceName()));

        if (list.size() > 0) {
            List<ProvinceEntity> entityList = conventor.convertProvince(list);
            for (ProvinceEntity entity : entityList) {
                entity.setId(ObjectId.get().toString());
                provinceDao.createProvince(entity);
                log.info("Success create province into database, provinceName: {}", entity.getName());
            }
        }
    }

}
