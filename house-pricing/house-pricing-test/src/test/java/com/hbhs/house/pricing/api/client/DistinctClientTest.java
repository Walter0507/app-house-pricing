package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.DistinctCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DistinctClientTest extends BaseClientTest {

    @Autowired
    private DistinctClient distinctClient;

    @Test
    public void testBasicFlow() {
        DistinctCreateParam param = DistinctCreateParam.builder()
                // TODO
                .build();
        GenericRequest<DistinctCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        DistinctInfo info = distinctClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        DistinctUpdateParam updateParam = DistinctUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<DistinctUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = distinctClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = distinctClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = distinctClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = distinctClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
