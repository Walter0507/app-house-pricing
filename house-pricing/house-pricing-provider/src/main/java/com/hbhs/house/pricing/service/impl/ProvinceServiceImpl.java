package com.hbhs.house.pricing.service.impl;

import com.hbhs.house.pricing.convertor.province.ProvinceCommonDataConvertor;
import com.hbhs.house.pricing.convertor.province.ProvinceQueryParam2CriteriaConvertor;
import com.hbhs.house.pricing.repository.dao.IProvinceDao;
import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.house.pricing.domain.request.param.ProvinceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import com.hbhs.house.pricing.service.IProvinceService;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    private IProvinceDao provinceDao;
    @Autowired
    private ProvinceCommonDataConvertor commonDataConvertor;
    @Autowired
    private ProvinceQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public ProvinceInfo createProvince(ProvinceCreateParam param) {
        ProvinceEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = provinceDao.createProvince(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateProvince(ProvinceUpdateParam param) {
        ProvinceEntity entity = commonDataConvertor.updateParam2Entity(param);
        return provinceDao.updateProvince(entity);
    }

    @Override
    public Boolean deleteProvince(String id) {
        return provinceDao.deletedProvince(id);
    }

    @Override
    public ProvinceInfo findProvinceById(String id) {
        ProvinceEntity entity = provinceDao.findProvinceById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<ProvinceInfo> queryProvince(ProvinceQueryParam param, Pagination pagination) {
        ProvinceCriteria criteria = criteriaConvertor.convert(param);

        List<ProvinceEntity> entityList = provinceDao.findProvinceByCriteria(criteria, pagination);

        List<ProvinceInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<ProvinceInfo> result = TResultBuilder.succPageResult(ProvinceInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
