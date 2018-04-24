package com.cpal.common.util;

import static com.cpal.common.unit.test.CommonMatcher.isExactly;
import static com.cpal.common.util.NumberUtil.add;
import static com.cpal.common.util.NumberUtil.divide;
import static com.cpal.common.util.NumberUtil.multiply;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NumberUtilTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void add_whenPriceAndRateValid_returnsSumAmount() {
        BigDecimal actual = add(valueOf(1000), valueOf(5));

        assertThat(actual, isExactly(1005));
    }

    @Test
    public void add_whenPriceIsNull_returnsRate() {
        BigDecimal actual = add(null, valueOf(5));

        assertThat(actual, isExactly(5));
    }

    @Test
    public void add_whenRateIsNull_returnsPrice() {
        BigDecimal actual = add(valueOf(1000), null);

        assertThat(actual, isExactly(1000));
    }
    
    @Test
    public void multiply_returnMultiplication_whenArrayHasValues() {
    	assertThat(multiply(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.TEN), isExactly(100));
    }
    
    @Test
    public void multiply_returnsZero_whenArrayHasZero() {
    	assertThat(multiply(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN), isExactly(0));
    }
    
    @Test
    public void multiply_returnsMultiplication_whenArrayHasNull() {
    	assertThat(multiply(null, BigDecimal.TEN, BigDecimal.TEN), isExactly(100));
    }
    
    @Test
    public void divide_returnsQuotient_whenValuesValid() {
    	assertThat(divide(BigDecimal.TEN, BigDecimal.TEN), isExactly(1));
    }

    @Test
    public void divide_returnsNull_whenAnyValueNull() {
    	assertNull(divide(null, BigDecimal.TEN));
    	assertNull(divide(BigDecimal.TEN, null));
    }
    
    @Test
    public void divide_returnsDefaultPrecesion_whenNoRoundingIsPassed() {
    	assertThat(NumberUtil.divide(BigDecimal.TEN, new BigDecimal(3)), isExactly(3.33));
    }
    
    @Test
    public void divide_returnsValue_whenRoundingIsPassed() {
    	assertThat(NumberUtil.divide(BigDecimal.TEN, new BigDecimal(3), 3), isExactly(3.333));
    }
}
