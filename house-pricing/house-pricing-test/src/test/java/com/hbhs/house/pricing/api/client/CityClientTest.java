package com.hbhs.house.pricing.api.client;

import com.hbhs.house.pricing.api.BaseClientTest;
import com.hbhs.house.pricing.domain.request.param.CityCreateParam;
import com.hbhs.house.pricing.domain.request.param.CityUpdateParam;
import com.hbhs.house.pricing.domain.response.info.CityInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CityClientTest extends BaseClientTest {

    @Autowired
    private CityClient cityClient;

    @Test
    public void testBasicFlow() {
        CityCreateParam param = CityCreateParam.builder()
                // TODO
                .build();
        GenericRequest<CityCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        CityInfo info = cityClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        CityUpdateParam updateParam = CityUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<CityUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = cityClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = cityClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = cityClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = cityClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
