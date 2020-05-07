package com.hbhs.house.pricing.api.fallback;

import com.hbhs.house.pricing.api.client.ProvincePriceClient;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvincePriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvincePriceInfo;
import com.hbhs.common.domain.consts.ErrorCodeConsts;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.stereotype.Component;

@Component
public class ProvincePriceClientFallback implements ProvincePriceClient {
    @Override
    public TSingleResult<ProvincePriceInfo> create(GenericRequest<ProvincePriceCreateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<ProvincePriceUpdateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<ProvincePriceInfo> findById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TPageResult<ProvincePriceInfo> queryProvincePrice(QueryRequest<ProvincePriceQueryParam> request) {
        return TResultBuilder.failTPage(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }
}
