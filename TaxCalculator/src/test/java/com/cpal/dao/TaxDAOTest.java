package com.cpal.dao;

import com.cpal.vo.Type;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
public class TaxDAOTest {

    private TaxDAO subject;

    @Before
    public void setup() {
        subject = new TaxDAO();
    }

    @Test
    public void getStates_ReturnAllTheStateNames() throws Exception {
        List<Type> types = subject.getStates();

        assertThat(types.size(), is(50));
        assertThat(types.get(0).getCode(), is("AL"));
        assertThat(types.get(0).getValue(), is("Alabama"));
    }
}
