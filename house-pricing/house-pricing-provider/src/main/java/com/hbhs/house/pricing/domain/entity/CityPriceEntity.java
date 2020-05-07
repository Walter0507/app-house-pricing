package com.hbhs.house.pricing.domain.entity;

import com.hbhs.common.domain.model.BaseEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class CityPriceEntity extends BaseEntity {
    private java.lang.String id;
    private java.lang.String provinceId;
    private java.lang.String cityId;
    private java.util.Date loadDay;
    private Date week;
    private Date month;
    private java.lang.Long sellingCount;
    private java.lang.Long sellingAvgPrice;

}
