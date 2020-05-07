package com.hbhs.house.pricing.repository.dao.impl;

import com.hbhs.house.pricing.repository.dao.IProvinceDao;
import com.hbhs.house.pricing.repository.dao.mapper.ProvinceMapper;
import com.hbhs.house.pricing.domain.criteria.ProvinceCriteria;
import com.hbhs.house.pricing.domain.entity.ProvinceEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Slf4j
public class ProvinceDaoImpl implements IProvinceDao {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public Boolean createProvince(ProvinceEntity entity) {
        return provinceMapper.insertProvince(entity);
    }

    @Override
    public Boolean batchCreateProvince(List<ProvinceEntity> entityList) {
        return provinceMapper.batchInsertProvince(entityList);
    }

    @Override
    public Boolean updateProvince(ProvinceEntity entity) {
        return provinceMapper.updateProvince(entity);
    }

    @Override
    public Boolean deletedProvince(String id) {
        return provinceMapper.deleteProvince(id);
    }

    @Override
    @ReadOnlyConnection
    public ProvinceEntity findProvinceById(String id) {
        return provinceMapper.findProvinceById(id);
    }

    @Override
    public List<ProvinceEntity> findProvinceByCriteria(ProvinceCriteria criteria, Pagination pagination) {
        return provinceMapper.findProvinceByCriteria(criteria);
    }
}
