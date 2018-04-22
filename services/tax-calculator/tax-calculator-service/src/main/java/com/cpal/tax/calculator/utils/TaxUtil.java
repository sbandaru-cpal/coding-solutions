package com.cpal.tax.calculator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.valueOf;

public class TaxUtil {

    public static final int ROUNDING = 2;

    public static BigDecimal calculatePercentageAmount(BigDecimal price, BigDecimal taxRate) {
        return (price.multiply(taxRate)).divide(valueOf(100)).setScale(ROUNDING, RoundingMode.HALF_UP);
    }
}
