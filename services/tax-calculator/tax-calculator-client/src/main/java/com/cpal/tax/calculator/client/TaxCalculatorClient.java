package com.cpal.tax.calculator.client;

import com.cpal.tax.calculator.vo.TypeData;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.List;

public class TaxCalculatorClient {

    private RestTemplate taxCalculatorTemplate = new RestTemplate();
    private String baseURL;

    public TaxCalculatorClient(final String host, final String port) {
        this.baseURL = "http://" + host + ":" + port;
        this.taxCalculatorTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(this.baseURL));
    }

    public String getTax() {
        return taxCalculatorTemplate.getForEntity("/tax", String.class).getBody();
    }


    public List<TypeData> getAllStates() {
        return taxCalculatorTemplate.getForEntity("/tax/states", List.class).getBody();
    }



}
