package com.hbhs.house.pricing.domain.response.info;

import com.hbhs.common.domain.model.response.info.BaseInfo;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class ProvinceInfo extends BaseInfo {
    private java.lang.String id;
    private java.lang.String name;
    private java.lang.String searchUrlLianjia;

}
