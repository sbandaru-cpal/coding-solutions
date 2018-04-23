package com.cpal.tax.calculator.util;

import static com.cpal.common.unit.test.CommonMatcher.isExactly;
import static com.cpal.tax.calculator.util.TaxUtil.calculateSalesTax;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxUtilTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void calculatePercentageAmount_whenPriceAndRateValid_returnsCalculatedAmount() {
        BigDecimal actual = calculateSalesTax(valueOf(1000), valueOf(5));

        assertThat(actual, isExactly(50));
    }

    @Test
    public void calculatePercentageAmount_whenPriceIsNull_returnsNull() {
        BigDecimal actual = calculateSalesTax(null, valueOf(5));

        assertThat(actual, nullValue());
    }

    @Test
    public void calculatePercentageAmount_whenRateIsNull_throwsException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(is("Invalid argument for calculating percentage"));
        calculateSalesTax(valueOf(1000), null);
    }

    @Test
    public void calculatePercentageAmount_whenRateIsZero_returnsZero() {
        BigDecimal actual = calculateSalesTax(valueOf(1000), ZERO);

        assertThat(actual, isExactly(0));
    }

}
