package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.GenerateLogCreateParam;
import com.hbhs.house.pricing.domain.request.param.GenerateLogUpdateParam;
import com.hbhs.house.pricing.domain.response.info.GenerateLogInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenerateLogClientTest extends BaseClientTest {

    @Autowired
    private GenerateLogClient generateLogClient;

    @Test
    public void testBasicFlow() {
        GenerateLogCreateParam param = GenerateLogCreateParam.builder()
                // TODO
                .build();
        GenericRequest<GenerateLogCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        GenerateLogInfo info = generateLogClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        GenerateLogUpdateParam updateParam = GenerateLogUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<GenerateLogUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = generateLogClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = generateLogClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = generateLogClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = generateLogClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
