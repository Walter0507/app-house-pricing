package com.hbhs.house.pricing.domain.entity;

import com.hbhs.common.domain.model.BaseEntity;
import com.hbhs.house.pricing.domain.enums.GenerateType;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class GenerateLogEntity extends BaseEntity {
    private GenerateType type;
    private java.lang.String id;
    private java.lang.String loadDay;

}
