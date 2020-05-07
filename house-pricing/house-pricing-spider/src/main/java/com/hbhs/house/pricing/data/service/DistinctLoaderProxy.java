package com.hbhs.house.pricing.data.service;

import com.hbhs.common.tools.id.mongodb.ObjectId;
import com.hbhs.house.pricing.data.convertor.CrawlEntityConventor;
import com.hbhs.house.pricing.data.convertor.LocalCacheService;
import com.hbhs.house.pricing.data.dto.CrawlDistinct;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.house.pricing.repository.dao.IDistinctDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DistinctLoaderProxy {
    @Autowired
    private CrawlEntityConventor conventor;
    @Autowired
    private LocalCacheService localCacheService;
    @Autowired
    private IDistinctDao distinctDao;

    public void saveDistinct(List<CrawlDistinct> distinctList) {
        if (distinctList == null || distinctList.size() == 0) {
            return;
        }
        distinctList.removeIf(distinct -> localCacheService.findDistinctId(distinct.getCityId(),distinct.getDistinctName())!=null);

        if (distinctList.size() > 0) {
            List<DistinctEntity> entityList = conventor.convertDistinct(distinctList);
            for (DistinctEntity entity : entityList) {
                entity.setId(ObjectId.get().toString());
                distinctDao.createDistinct(entity);
            }
        }
    }
}
