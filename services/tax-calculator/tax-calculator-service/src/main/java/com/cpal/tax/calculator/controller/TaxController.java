package com.cpal.tax.calculator.controller;

import com.cpal.tax.calculator.dao.StateDAO;
import com.cpal.tax.calculator.vo.TypeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tax")
@RestController
public class TaxController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaxController.class);


    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String index() {
        LOGGER.info("Returns sample response");
        return "Return Tax results for all the states!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/states")
    public @ResponseBody List<TypeData> getAllStateInfo() {
        LOGGER.info("Returns List of all the states codes and Names");
        return new StateDAO().findAllStates();
    }
}