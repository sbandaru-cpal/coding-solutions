package com.cpal.tax.calculator.service;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TaxPrice;
import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.dao.StateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.cpal.tax.calculator.utils.TaxUtil.calculatePercentageAmount;

@Service
public class StateService {

    @Autowired
    private StateDAO stateDAO;

    public List<TypeData> getAllStates() {
        return stateDAO.findAllStates();
    }

    public BigDecimal calculateTaxedTotalPrice(State state, BigDecimal price) {
        BigDecimal taxPercent = getStateTaxRate(state);
        return price.add(calculatePercentageAmount(price, taxPercent));
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
        BigDecimal taxableAmount = calculatePercentageAmount(price, stateTaxRate);
        taxPrice.setTaxRate(stateTaxRate);
        taxPrice.setTaxAmount(taxableAmount);
        taxPrice.setState(state);
        taxPrice.setTotalAmount(price.add(taxableAmount));
        return taxPrice;
    }

    private BigDecimal getStateTaxRate(State state) {
        return stateDAO.findStateTaxRate(state);
    }


}
