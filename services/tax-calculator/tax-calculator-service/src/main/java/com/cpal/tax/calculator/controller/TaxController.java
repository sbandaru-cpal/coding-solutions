package com.cpal.tax.calculator.controller;

import java.math.BigDecimal;
import java.util.List;

import com.cpal.tax.calculator.api.TaxPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.service.StateService;

@RequestMapping(value= "/tax", produces={MediaType.APPLICATION_JSON_VALUE})
@RestController
public class TaxController {

    @Autowired
    private StateService stateService;

    @RequestMapping(method = RequestMethod.GET, value = "/states")
    public @ResponseBody List<TypeData> getAllStateInfo() {
        return stateService.getAllStates();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/calculate/{state}/{price}")
    public @ResponseBody TaxPrice calculateTax(@PathVariable State state, @PathVariable BigDecimal price) {
        return stateService.calculateTaxedTotalPrice(state, price);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calculate/{price}")
    public @ResponseBody List<TaxPrice> calculateTax(@PathVariable BigDecimal price) {
        return stateService.calculateTotalPriceForAllStates(price);
    }
}