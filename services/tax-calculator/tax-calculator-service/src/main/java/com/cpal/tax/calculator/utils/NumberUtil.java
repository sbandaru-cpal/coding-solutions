package com.cpal.tax.calculator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.valueOf;

public class NumberUtil {
    private NumberUtil(){}

    private static final int ROUNDING = 2;

    public static BigDecimal calculatePercentageAmount(BigDecimal price, BigDecimal rate) {
        if(anyNulls(price, rate)){
            return null;
        }
        return (price.multiply(rate)).divide(valueOf(100)).setScale(ROUNDING, RoundingMode.HALF_UP);
    }

    public static BigDecimal add(BigDecimal price, BigDecimal rate){
        if(anyNulls(price, rate)){
            return null;
        }
        return price.add(rate);
    }

    private static boolean anyNulls(BigDecimal price, BigDecimal rate) {
        if(price == null || rate == null){
            return true;
        }
        return false;
    }
}
