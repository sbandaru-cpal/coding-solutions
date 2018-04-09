package com.cpal.tax.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tax")
@RestController
public class TaxController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaxController.class);


    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String index() {
        LOGGER.info("Returns sample response");
        return "Return Tax results for all the states!";
    }
}