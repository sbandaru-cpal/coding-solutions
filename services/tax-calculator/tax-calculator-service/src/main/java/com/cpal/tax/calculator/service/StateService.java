package com.cpal.tax.calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpal.tax.calculator.api.State;
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
		BigDecimal taxPercent = stateDAO.findStateTaxRate(state).divide(new BigDecimal(100));
		return price.add(price.multiply(taxPercent)).setScale(2, RoundingMode.HALF_UP);
    }

}
