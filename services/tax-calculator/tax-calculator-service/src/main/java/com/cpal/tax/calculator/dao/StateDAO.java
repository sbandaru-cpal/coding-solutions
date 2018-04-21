package com.cpal.tax.calculator.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.StateTax;
import com.cpal.tax.calculator.api.TypeData;

@Repository
public class StateDAO {
	
	private static final List<TypeData> STATES = Stream.of(State.values()).map(p -> new TypeData(p.name(), p.getDescription())).collect(Collectors.toList());
	

    public List<TypeData> findAllStates() {
        return STATES;
    }
    
    public BigDecimal findStateTaxRate(String state) {
        return StateTax.valueOf(state).getTaxRate();
    }

}
