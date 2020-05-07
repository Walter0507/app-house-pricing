package com.hbhs.house.pricing.service.impl;

import com.hbhs.house.pricing.convertor.distinct.DistinctCommonDataConvertor;
import com.hbhs.house.pricing.convertor.distinct.DistinctQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.repository.dao.IDistinctDao;
import com.hbhs.house.pricing.domain.criteria.DistinctCriteria;
import com.hbhs.house.pricing.domain.entity.DistinctEntity;
import com.hbhs.house.pricing.domain.request.param.DistinctCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.house.pricing.service.IDistinctService;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DistinctServiceImpl implements IDistinctService {
    @Autowired
    private IDistinctDao distinctDao;
    @Autowired
    private DistinctCommonDataConvertor commonDataConvertor;
    @Autowired
    private DistinctQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public DistinctInfo createDistinct(DistinctCreateParam param) {
        DistinctEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = distinctDao.createDistinct(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateDistinct(DistinctUpdateParam param) {
        DistinctEntity entity = commonDataConvertor.updateParam2Entity(param);
        return distinctDao.updateDistinct(entity);
    }

    @Override
    public Boolean deleteDistinct(String id) {
        return distinctDao.deletedDistinct(id);
    }

    @Override
    public DistinctInfo findDistinctById(String id) {
        DistinctEntity entity = distinctDao.findDistinctById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<DistinctInfo> queryDistinct(DistinctQueryParam param, Pagination pagination) {
        DistinctCriteria criteria = criteriaConvertor.convert(param);

        List<DistinctEntity> entityList = distinctDao.findDistinctByCriteria(criteria, pagination);

        List<DistinctInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<DistinctInfo> result = TResultBuilder.succPageResult(DistinctInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
