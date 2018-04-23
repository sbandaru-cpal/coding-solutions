package com.cpal.tax.calculator.utils;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static com.cpal.tax.calculator.utils.NumberUtil.add;
import static com.cpal.tax.calculator.utils.NumberUtil.calculatePercentageAmount;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NumberUtilTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void calculatePercentageAmount_whenPriceAndRateValid_returnsCalculatedAmount() {
        BigDecimal actual = calculatePercentageAmount(valueOf(1000), valueOf(5));

        assertThat(actual, isExactly(50));
    }

    @Test
    public void calculatePercentageAmount_whenPriceIsNull_returnsNull() {
        BigDecimal actual = calculatePercentageAmount(null, valueOf(5));

        assertThat(actual, nullValue());
    }

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
    public void calculatePercentageAmount_whenRateIsNull_throwsException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(is("Invalid argument for calculating percentage"));
        calculatePercentageAmount(valueOf(1000), null);
    }

    @Test
    public void calculatePercentageAmount_whenRateIsZero_returnsZero() {
        BigDecimal actual = calculatePercentageAmount(valueOf(1000), ZERO);

        assertThat(actual, isExactly(0));
    }

    public static Matcher<BigDecimal> isExactly(final double value) {
        return closeTo(BigDecimal.valueOf(value), BigDecimal.ZERO);
    }
}
