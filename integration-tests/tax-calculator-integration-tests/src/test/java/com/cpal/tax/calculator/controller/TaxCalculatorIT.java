package com.cpal.tax.calculator.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.client.TaxCalculatorClient;

public class TaxCalculatorIT {

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
	
}
