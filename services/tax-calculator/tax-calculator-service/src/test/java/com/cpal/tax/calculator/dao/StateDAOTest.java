package com.cpal.tax.calculator.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cpal.tax.calculator.api.TypeData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StateDAOTest {

	@Autowired
    private StateDAO subject;

    @Test
    public void findAllStates_returnAllTheStateCodesAndNames() {
        List<TypeData> typeData = subject.findAllStates();
        assertThat(typeData.size(), is(50));
    }
}
