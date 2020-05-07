package com.hbhs.house.pricing.domain.entity;

import com.hbhs.common.domain.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class ProvincePriceEntity extends BaseEntity {
    private java.lang.String id;
    private java.lang.String provinceId;
    private java.util.Date week;
    private java.util.Date month;
    private java.lang.Long sellingCount;
    private java.lang.Long sellingAvgPrice;

}
