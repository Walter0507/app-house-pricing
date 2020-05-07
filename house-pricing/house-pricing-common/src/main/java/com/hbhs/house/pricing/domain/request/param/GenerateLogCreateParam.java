package com.hbhs.house.pricing.domain.request.param;

import com.hbhs.common.domain.model.request.param.BaseParam;
import com.hbhs.house.pricing.domain.enums.GenerateType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString(callSuper = true)@Builder
public class GenerateLogCreateParam extends BaseParam {
    private GenerateType type;
    private java.lang.String id;
    private java.lang.String loadDay;


    @Override
    public void checkParam() {
        // TODO
    }
}
