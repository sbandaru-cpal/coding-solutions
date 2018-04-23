package com.cpal.tax.calculator.util;

import static com.cpal.common.util.NumberUtil.divide;
import static com.cpal.common.util.NumberUtil.multiply;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;

public class TaxUtil {
	
	private TaxUtil() {
		
	}
	
	public static BigDecimal calculateSalesTax(BigDecimal price, BigDecimal rate) {
        if (price == null) {
            return null;
        } 
        
        if (rate == null){
            throw new UnsupportedOperationException("Invalid operation for Calculating");
        }
        return divide(multiply(price,rate), valueOf(100));
    }

}
