package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctPriceInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DistinctPriceClientTest extends BaseClientTest {

    @Autowired
    private DistinctPriceClient distinctPriceClient;

    @Test
    public void testBasicFlow() {
        DistinctPriceCreateParam param = DistinctPriceCreateParam.builder()
                // TODO
                .build();
        GenericRequest<DistinctPriceCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        DistinctPriceInfo info = distinctPriceClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        DistinctPriceUpdateParam updateParam = DistinctPriceUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<DistinctPriceUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = distinctPriceClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = distinctPriceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = distinctPriceClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = distinctPriceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
