package com.cpal.tax.calculator.controller;

import com.cpal.tax.calculator.client.TaxCalculatorClient;
import com.cpal.tax.calculator.vo.TypeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TaxCalculatorIT {

	private TaxCalculatorClient taxCalculatorClient = new TaxCalculatorClient("localhost", "8888");

	@Test
	public void getTax_returnsValidResponse()  {
		assertThat(taxCalculatorClient.getTax(), equalTo("Return Tax results for all the states!"));
	}

	@Test
	public void getStatesInfo_returnsValidResponse() {
		List<TypeData> typeDataList  = (ArrayList<TypeData>) taxCalculatorClient.getAllStates();

		TypeData typeDataFirstElement = typeDataList.get(0);
		assertThat(typeDataFirstElement.getCode(), is("AL"));
		assertThat(typeDataFirstElement.getValue(), is("Alaska"));
	}

}
