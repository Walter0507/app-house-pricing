package com.hbhs.house.pricing.api.fallback;

import com.hbhs.house.pricing.api.client.ProvinceClient;
import com.hbhs.house.pricing.domain.request.param.ProvinceCreateParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceQueryParam;
import com.hbhs.house.pricing.domain.request.param.ProvinceUpdateParam;
import com.hbhs.house.pricing.domain.response.info.ProvinceInfo;
import com.hbhs.common.domain.consts.ErrorCodeConsts;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.stereotype.Component;

@Component
public class ProvinceClientFallback implements ProvinceClient {
    @Override
    public TSingleResult<ProvinceInfo> create(GenericRequest<ProvinceCreateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<ProvinceUpdateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<ProvinceInfo> findById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TPageResult<ProvinceInfo> queryProvince(QueryRequest<ProvinceQueryParam> request) {
        return TResultBuilder.failTPage(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }
}
