package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvincePriceInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvincePriceClientTest extends BaseClientTest {

    @Autowired
    private ProvincePriceClient provincePriceClient;

    @Test
    public void testBasicFlow() {
        ProvincePriceCreateParam param = ProvincePriceCreateParam.builder()
                // TODO
                .build();
        GenericRequest<ProvincePriceCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        ProvincePriceInfo info = provincePriceClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        ProvincePriceUpdateParam updateParam = ProvincePriceUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<ProvincePriceUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = provincePriceClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = provincePriceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = provincePriceClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = provincePriceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
