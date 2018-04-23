package com.cpal.tax.calculator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.valueOf;

public class NumberUtil {
    private NumberUtil(){}

    private static final int ROUNDING = 2;

    public static BigDecimal calculatePercentageAmount(BigDecimal price, BigDecimal rate) {
        if (price == null) {
            return null;
        } if (rate == null){
            throw new IllegalArgumentException("Invalid argument for calculating percentage");
        }
        return (price.multiply(rate)).divide(valueOf(100)).setScale(ROUNDING, RoundingMode.HALF_UP);
    }

    public static BigDecimal add(BigDecimal price, BigDecimal taxableAmount) {
        if (price == null) {
            return taxableAmount;
        }
        if (taxableAmount == null) {
            return price;
        }
        return price.add(taxableAmount);
    }
}
