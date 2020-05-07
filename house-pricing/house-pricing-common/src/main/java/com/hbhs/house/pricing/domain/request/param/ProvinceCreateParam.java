package com.hbhs.house.pricing.domain.request.param;

import com.hbhs.common.domain.model.request.param.BaseParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString(callSuper = true)@Builder
public class ProvinceCreateParam extends BaseParam {
    private java.lang.String id;
    private java.lang.String name;
    private java.lang.String searchUrlLianjia;


    @Override
    public void checkParam() {
        // TODO
    }
}
