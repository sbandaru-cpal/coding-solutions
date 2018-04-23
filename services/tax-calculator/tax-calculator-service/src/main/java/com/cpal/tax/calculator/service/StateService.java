package com.cpal.tax.calculator.service;

import static com.cpal.common.util.NumberUtil.add;
import static com.cpal.tax.calculator.TaxCalculator.calculateSalesTax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TaxPrice;
import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.dao.StateDAO;

@Service
public class StateService {

    @Autowired
    private StateDAO stateDAO;

    public List<TypeData> getAllStates() {
        return stateDAO.findAllStates();
    }

    public BigDecimal calculateTaxedTotalPrice(State state, BigDecimal price) {
        BigDecimal taxPercent = getStateTaxRate(state);
        return add(price,calculateSalesTax(price, taxPercent));
    }

    public List<TaxPrice> calculateTotalPriceForAllStates(BigDecimal price) {
        List<TaxPrice> taxPrices = new ArrayList<>();
        for (State state : State.values()) {
            taxPrices.add(buildTaxPrice(price, state));
        }
        return taxPrices;
    }

    private TaxPrice buildTaxPrice(BigDecimal price, State state) {
        TaxPrice taxPrice = new TaxPrice();
        BigDecimal stateTaxRate = getStateTaxRate(state);
        BigDecimal taxableAmount = calculateSalesTax(price, stateTaxRate);
        taxPrice.setTaxRate(stateTaxRate);
        taxPrice.setTaxAmount(taxableAmount);
        taxPrice.setState(state);
        taxPrice.setTotalAmount(add(price, taxableAmount));
        return taxPrice;
    }

    private BigDecimal getStateTaxRate(State state) {
        return stateDAO.findStateTaxRate(state);
    }


}
