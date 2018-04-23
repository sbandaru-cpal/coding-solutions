package com.cpal.tax.calculator.service;

import static com.cpal.common.unit.test.CommonMatcher.isExactly;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TaxPrice;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StateServiceTest {

    public static final BigDecimal PRICE = new BigDecimal(1000);
    @Autowired
    private StateService subject;

    @Test
    public void getAllStates_returnAllStates() {
        assertThat(subject.getAllStates().size(), is(51));
    }

    @Test
    public void calculateTotalPrice_returnTotalPriceForCalifornia() {
        BigDecimal actual = subject.calculateTaxedTotalPrice(State.CA, PRICE);

        assertThat(actual, isExactly(1072.50));
    }

    @Test
    public void calculateTaxedAmountForAllStates_returnsPricesForAllStates() {
        List<TaxPrice> actual = subject.calculateTotalPriceForAllStates(PRICE);

        assertThat(actual.size(), is(51));
        assertThat(actual.get(0).getState().name(), is("AL"));
        assertThat(actual.get(0).getTaxRate(), isExactly(4));
        assertThat(actual.get(0).getTaxAmount(), isExactly(40));
        assertThat(actual.get(0).getTotalAmount(), isExactly(1040));
    }
}
