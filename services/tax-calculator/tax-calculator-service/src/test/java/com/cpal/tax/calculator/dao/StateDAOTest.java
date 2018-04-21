package com.cpal.tax.calculator.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cpal.tax.calculator.api.State;
import com.cpal.tax.calculator.api.TypeData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StateDAOTest {

	@Autowired
    private StateDAO subject;

    @Test
    public void findAllStates_returnAllTheStateCodesAndNames() {
        List<TypeData> typeData = subject.findAllStates();
        assertThat(typeData.size(), is(51));
    }
    
    @Test
    public void findStateTax_returnStateTaxForCalifornia() {
        assertThat(subject.findStateTaxRate(State.CA.name()), is(new BigDecimal(7.25)));
    }
    
    @Test(expected=NullPointerException.class)
    public void findStateTax_returnStateTaxForWrongStateCode() {
        subject.findStateTaxRate(null);
    }
    
}
