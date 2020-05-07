package com.hbhs.house.pricing.domain.response.info;

import com.hbhs.common.domain.model.response.info.BaseInfo;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class ProvincePriceInfo extends BaseInfo {
    private java.lang.String id;
    private java.lang.String provinceId;
    private java.util.Date week;
    private java.util.Date month;
    private java.lang.Long sellingCount;
    private java.lang.Long sellingAvgPrice;

}
