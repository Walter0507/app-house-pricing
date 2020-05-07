package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.CityPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityPriceInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CityPriceClientTest extends BaseClientTest {

    @Autowired
    private CityPriceClient cityPriceClient;

    @Test
    public void testBasicFlow() {
        CityPriceCreateParam param = CityPriceCreateParam.builder()
                // TODO
                .build();
        GenericRequest<CityPriceCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        CityPriceInfo info = cityPriceClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        CityPriceUpdateParam updateParam = CityPriceUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<CityPriceUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = cityPriceClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = cityPriceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = cityPriceClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = cityPriceClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
