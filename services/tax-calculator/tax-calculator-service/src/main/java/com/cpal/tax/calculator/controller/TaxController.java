package com.cpal.tax.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}