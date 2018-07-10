package com.cpal.work.force.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

public class WorkForceClient {

	private RestTemplate workForceTemplate = new RestTemplate();
	private String baseURL;

	public WorkForceClient(final String host, final String port) {
		this.baseURL = "http://" + host + ":" + port+"/workforce/";
		this.workForceTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(this.baseURL));
	}

	public String getMessage() {
		ResponseEntity<String> messageResponse =
				workForceTemplate.exchange("message",
						HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				});
		return messageResponse.getBody();
	}

}
