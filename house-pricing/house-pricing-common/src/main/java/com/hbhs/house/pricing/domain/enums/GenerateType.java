package com.hbhs.house.pricing.domain.enums;

import com.hbhs.common.domain.model.BaseEnum;

public enum GenerateType implements BaseEnum {
    // TODO
    ;

    private int code;
    private String name;

    GenerateType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public static GenerateType findByName(String name){
        for (GenerateType value : values()) {
            if (value.name.equalsIgnoreCase(name)){
                return value;
            }
        }
        return null;
    }

    public static GenerateType findByCode(int code){
        for (GenerateType value : values()) {
            if (value.code == code){
                return value;
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
