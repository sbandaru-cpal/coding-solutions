package com.cpal.common.unit.test;

import static org.hamcrest.Matchers.closeTo;

import java.math.BigDecimal;

import org.hamcrest.Matcher;

public class CommonMatcher {

	private CommonMatcher() {

	}

	public static Matcher<BigDecimal> isExactly(final double value) {
		return closeTo(BigDecimal.valueOf(value), BigDecimal.ZERO);
	}

}
