package com.cpal.tax.calculator.dao;

import com.cpal.tax.calculator.vo.TypeData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
public class StateDAOTest {

    private StateDAO subject;

    @Before
    public void setup() {
        subject = new StateDAO();
    }

    @Test
    public void findAllStates_returnAllTheStateCodesAndNames() {
        List<TypeData> typeData = subject.findAllStates();

        assertThat(typeData.size(), is(50));
        assertThat(typeData.get(0).getCode(), is("AL"));
        assertThat(typeData.get(0).getValue(), is("Alabama"));
    }
}
