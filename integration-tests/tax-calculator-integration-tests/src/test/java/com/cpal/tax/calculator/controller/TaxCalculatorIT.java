package com.cpal.tax.calculator.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.cpal.tax.calculator.client.TaxCalculatorClient;

public class TaxCalculatorIT {

	private TaxCalculatorClient taxCalculatorClient = new TaxCalculatorClient("localhost", "8888");

	@Test
	public void getTax_returnsValidResponse() throws Exception {

		assertThat(taxCalculatorClient.getTax(), equalTo("Return Tax results for all the states!"));
	}

}
