package com.cpal.tax.calculator.service;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TaxPrice;
import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.dao.StateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.valueOf;

@Service
public class StateService {
    private static final int ROUNDING = 2;

    @Autowired
    private StateDAO stateDAO;

    public List<TypeData> getAllStates() {
        return stateDAO.findAllStates();
    }

    public BigDecimal calculateTaxedTotalPrice(State state, BigDecimal price) {
        BigDecimal taxPercent = getStateTaxRate(state.name());
        BigDecimal taxableAmount = calculateTaxableAmount(price, taxPercent);
        return price.add(taxableAmount);

    }

    public List<TaxPrice> calculateTotalPriceForAllStates(BigDecimal price) {
        List<TypeData> states = getAllStates();
        List<TaxPrice> taxPrices = new ArrayList<>();
        for (TypeData typeData : states) {
            taxPrices.add(buildTaxPrice(price, typeData));
        }
        return taxPrices;
    }

    private TaxPrice buildTaxPrice(BigDecimal price, TypeData typeData) {
        TaxPrice taxPrice = new TaxPrice();
        BigDecimal stateTaxRate = getStateTaxRate(typeData.getCode());
        BigDecimal taxableAmount = calculateTaxableAmount(price, stateTaxRate);
        taxPrice.setTaxRate(stateTaxRate);
        taxPrice.setTaxAmount(taxableAmount);
        taxPrice.setStateCode(typeData.getCode());
        taxPrice.setTotalAmount(price.add(taxableAmount));
        return taxPrice;
    }

    private BigDecimal getStateTaxRate(String state) {
        return stateDAO.findStateTaxRate(state);
    }

    private BigDecimal calculateTaxableAmount(BigDecimal price, BigDecimal taxRate) {
        return (price.multiply(taxRate)).divide(valueOf(100)).setScale(ROUNDING, RoundingMode.HALF_UP);
    }

}
