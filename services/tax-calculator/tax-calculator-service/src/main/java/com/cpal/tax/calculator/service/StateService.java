package com.cpal.tax.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpal.tax.calculator.api.TypeData;
import com.cpal.tax.calculator.dao.StateDAO;

@Service
public class StateService {
	
	@Autowired
	private StateDAO stateDAO;

	public List<TypeData> getAllStates() {
		return stateDAO.findAllStates();
	}
	
	

}
