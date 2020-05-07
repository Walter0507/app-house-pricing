package com.hbhs.house.pricing.api.fallback;

import com.hbhs.house.pricing.api.client.DistinctPriceClient;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctPriceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctPriceInfo;
import com.hbhs.common.domain.consts.ErrorCodeConsts;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.stereotype.Component;

@Component
public class DistinctPriceClientFallback implements DistinctPriceClient {
    @Override
    public TSingleResult<DistinctPriceInfo> create(GenericRequest<DistinctPriceCreateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<DistinctPriceUpdateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<DistinctPriceInfo> findById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TPageResult<DistinctPriceInfo> queryDistinctPrice(QueryRequest<DistinctPriceQueryParam> request) {
        return TResultBuilder.failTPage(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }
}
