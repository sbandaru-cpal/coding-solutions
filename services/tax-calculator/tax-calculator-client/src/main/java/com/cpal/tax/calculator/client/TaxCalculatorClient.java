package com.cpal.tax.calculator.client;

import com.cpal.tax.calculator.api.TypeData;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.List;

public class TaxCalculatorClient {

	private RestTemplate taxCalculatorTemplate = new RestTemplate();
	private String baseURL;

	public TaxCalculatorClient(final String host, final String port) {
		this.baseURL = "http://" + host + ":" + port+"/tax/";
		this.taxCalculatorTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(this.baseURL));
	}

	public List<TypeData> getAllStates() {
		ResponseEntity<List<TypeData>> rateResponse =
				taxCalculatorTemplate.exchange("states",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<TypeData>>() {
				});
		return rateResponse.getBody();
	}



}
