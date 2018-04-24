package com.cpal.tax.calculator.controller;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TaxPrice;
import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.client.TaxCalculatorClient;

public class TaxCalculatorIT {

	private static final BigDecimal PRICE = new BigDecimal(1000);
	private TaxCalculatorClient taxCalculatorClient = new TaxCalculatorClient("localhost", "8888");

	@Test
	public void getStatesInfo_returnsValidResponse() {
		List<TypeData> typeDataList  = taxCalculatorClient.getAllStates();
		assertThat(typeDataList.size(), is(51));
	}

	@Test
	public void calculateTotalPrice_returnsTaxedTotalAmount() {
		BigDecimal taxedTotalAmount  = taxCalculatorClient.calculateTotalPrice(State.CA, new BigDecimal(1000));
		assertThat(taxedTotalAmount, Matchers.comparesEqualTo(new BigDecimal(1072.50)));
	}

	@Test
	public void calculateTotalPriceForAllStates_returnsTaxedAmounts() {
		List<TaxPrice> actual  = taxCalculatorClient.calculateTotalPriceForAllStates(PRICE);

		TaxPrice alTaxPrice = actual.stream().
			    filter(p -> p.getState().equals(State.AL)).
			    findFirst().get();
		
		assertThat(actual.size(), is(51));
		assertThat(alTaxPrice.getState().name(), is("AL"));
		assertThat(alTaxPrice.getTaxRate(), isExactly(4));
		assertThat(alTaxPrice.getTaxAmount(), isExactly(40));
		assertThat(alTaxPrice.getTotalAmount(), isExactly(1040));
	}

    public static Matcher<BigDecimal> isExactly(final double value) {
        return closeTo(BigDecimal.valueOf(value), BigDecimal.ZERO);
    }
	
}
