package com.cpal.tax.calculator.vo;

public class TypeData {

    private String code;
    private String value;

    public TypeData(String value, String code) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
