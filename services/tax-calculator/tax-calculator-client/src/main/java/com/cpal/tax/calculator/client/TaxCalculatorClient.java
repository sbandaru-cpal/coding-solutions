package com.cpal.tax.calculator.client;

import java.math.BigDecimal;
import java.util.List;

import com.cpal.tax.calculator.api.TaxPrice;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TypeData;

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
	
	public TaxPrice calculateTotalPrice(State state, BigDecimal price) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseURL+"calculate/")
		        .path(state.toString())
		        .path("/")
		        .path(price.toString());
		ResponseEntity<TaxPrice> rateResponse = taxCalculatorTemplate.exchange(builder.toUriString(),
						HttpMethod.POST, null, new ParameterizedTypeReference<TaxPrice>() {
				});
		return rateResponse.getBody();
	}

	public List<TaxPrice> calculateTotalPriceForAllStates(BigDecimal price) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseURL+"calculate/")
				.path(price.toString());

		ResponseEntity<List<TaxPrice>> rateResponse =
				taxCalculatorTemplate.exchange(builder.toUriString(),
						HttpMethod.GET, null, new ParameterizedTypeReference<List<TaxPrice>>() {
						});

		return rateResponse.getBody();
	}

}
