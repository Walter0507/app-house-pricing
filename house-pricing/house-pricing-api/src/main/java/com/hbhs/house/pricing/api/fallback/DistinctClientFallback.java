package com.hbhs.house.pricing.api.fallback;

import com.hbhs.house.pricing.api.client.DistinctClient;
import com.hbhs.house.pricing.domain.request.param.DistinctCreateParam;
import com.hbhs.house.pricing.domain.request.param.DistinctQueryParam;
import com.hbhs.house.pricing.domain.request.param.DistinctUpdateParam;
import com.hbhs.house.pricing.domain.response.info.DistinctInfo;
import com.hbhs.common.domain.consts.ErrorCodeConsts;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.stereotype.Component;

@Component
public class DistinctClientFallback implements DistinctClient {
    @Override
    public TSingleResult<DistinctInfo> create(GenericRequest<DistinctCreateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<DistinctUpdateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<DistinctInfo> findById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TPageResult<DistinctInfo> queryDistinct(QueryRequest<DistinctQueryParam> request) {
        return TResultBuilder.failTPage(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }
}
