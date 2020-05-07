package com.hbhs.house.pricing.domain.request.param;

import com.hbhs.common.domain.model.request.param.BaseParam;
import lombok.Data;

@Data
public class DistinctQueryParam extends BaseParam {

    private String cityId;

    @Override
    public void checkParam() {

    }
}
