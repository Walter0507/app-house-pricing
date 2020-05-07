package com.hbhs.house.pricing.utils;

public class NumberUtil {

    public static Integer parseInt(String arg, Integer defaultValue){
        if (arg == null||"".equals(arg)){
            return defaultValue;
        }
        try {
            return Integer.valueOf(arg.trim());
        }catch (Exception e){
            return defaultValue;
        }
    }
}
