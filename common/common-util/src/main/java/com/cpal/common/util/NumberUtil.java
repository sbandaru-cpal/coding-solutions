package com.cpal.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

public class NumberUtil {

	private static final int ROUNDING = 2;

	private NumberUtil(){}

	public static BigDecimal add(BigDecimal... values) {
		if(values == null){
			return BigDecimal.ZERO;
		}
		return Arrays.stream(values)
				.filter(Objects::nonNull)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public static BigDecimal multiply(BigDecimal... values) {
		if(values == null) {
			return BigDecimal.ZERO;
		}

		return Arrays.stream(values)
				.filter(Objects::nonNull)
				.reduce(BigDecimal.ONE, BigDecimal::multiply);
	}


	public  static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int rounding) {
		if(ObjectUtil.anyNulls(dividend, divisor)) {
			return null;
		}
		return dividend.divide(divisor, rounding, RoundingMode.HALF_UP);
	}

	public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
		return divide(dividend, divisor, ROUNDING);
	}

}
