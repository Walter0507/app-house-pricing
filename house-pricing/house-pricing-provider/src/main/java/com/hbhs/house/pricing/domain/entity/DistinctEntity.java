package com.hbhs.house.pricing.domain.entity;

import com.hbhs.common.domain.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class DistinctEntity extends BaseEntity {
    private java.lang.String id;
    private java.lang.String provinceId;
    private java.lang.String cityId;
    private java.lang.String name;
    private java.lang.String searchUrlLianjia;

}
