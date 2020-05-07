package com.hbhs.house.pricing.domain.response.info;

import com.hbhs.common.domain.model.response.info.BaseInfo;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class DistinctPriceInfo extends BaseInfo {
    private java.lang.String id;
    private java.lang.String provinceId;
    private java.lang.String cityId;
    private java.lang.String distinctId;
    private java.util.Date loadDay;
    private java.lang.Long sellingCount;
    private java.lang.Long sellingAvgPrice;

}
