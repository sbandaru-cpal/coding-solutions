package com.cpal.controller;

import com.cpal.TaxCalculatorService;
import com.cpal.dao.TaxDAO;
import com.cpal.vo.Type;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(TaxCalculatorService.class);

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String index() {
        LOGGER.info("Returns sample response");
        return "Return Tax results for all the states!";
    }


    @RequestMapping(method = RequestMethod.GET, value= "/states")
    public @ResponseBody  List<Type> states() {
        LOGGER.info("Returns List of all the states");
        return new TaxDAO().getStates();
    }
}
