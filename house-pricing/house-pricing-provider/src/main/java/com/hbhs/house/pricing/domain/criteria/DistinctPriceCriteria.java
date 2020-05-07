package com.hbhs.house.pricing.domain.criteria;

import lombok.Data;

import java.util.Date;

@Data
public class DistinctPriceCriteria {
    private java.lang.String provinceId;
    private java.lang.String cityId;
    private java.lang.String distinctId;
    private java.util.Date startDay;
    private Date endDay;
    private Date startWeek;
    private Date endWeek;
}
