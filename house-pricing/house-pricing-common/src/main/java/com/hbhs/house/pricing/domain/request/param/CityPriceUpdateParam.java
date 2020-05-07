package com.hbhs.house.pricing.domain.request.param;

import com.hbhs.common.domain.model.request.param.BaseParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class CityPriceUpdateParam extends BaseParam {
    private java.lang.String id;
    private java.lang.String provinceId;
    private java.lang.String cityId;
    private java.util.Date loadDay;
    private java.lang.Long sellingCount;
    private java.lang.Long sellingAvgPrice;


    @Override
    public void checkParam() {
        // TODO
    }
}
