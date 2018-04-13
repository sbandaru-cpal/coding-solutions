package com.cpal.tax.calculator.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.client.TaxCalculatorClient;

public class TaxCalculatorIT {

	private TaxCalculatorClient taxCalculatorClient = new TaxCalculatorClient("localhost", "8888");

	@Test
	public void getStatesInfo_returnsValidResponse() {
		List<TypeData> typeDataList  = taxCalculatorClient.getAllStates();

		assertThat(typeDataList.size(), is(50));
	}

}
