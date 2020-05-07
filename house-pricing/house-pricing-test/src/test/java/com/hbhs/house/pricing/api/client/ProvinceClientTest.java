package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.ProvinceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceClientTest extends BaseClientTest {

    @Autowired
    private ProvinceClient provinceClient;

    @Test
    public void testBasicFlow() {
        ProvinceCreateParam param = ProvinceCreateParam.builder()
                // TODO
                .build();
        GenericRequest<ProvinceCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        ProvinceInfo info = provinceClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        ProvinceUpdateParam updateParam = ProvinceUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<ProvinceUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = provinceClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = provinceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = provinceClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = provinceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
