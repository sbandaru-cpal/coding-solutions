package com.cpal.tax.calculator.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cpal.tax.calculator.api.State;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StateServiceTest {
	
	@Autowired
    private StateService stateService;
	
	@Test
    public void getAllStates_returnAllStates() {
		assertThat(stateService.getAllStates().size(), is(51));
    }
	 
	@Test
    public void calculateTotalPrice_returnTotalPriceForCalifornia() {
        assertThat(stateService.calculateTotalPrice(State.CA, new BigDecimal(1000)),Matchers.comparesEqualTo(new BigDecimal(1072.50)));
    }

}
