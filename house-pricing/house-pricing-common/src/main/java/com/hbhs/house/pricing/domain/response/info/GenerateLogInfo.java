package com.hbhs.house.pricing.domain.response.info;

import com.hbhs.common.domain.model.response.info.BaseInfo;
import com.hbhs.house.pricing.domain.enums.GenerateType;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class GenerateLogInfo extends BaseInfo {
    private GenerateType type;
    private java.lang.String id;
    private java.lang.String loadDay;

}
