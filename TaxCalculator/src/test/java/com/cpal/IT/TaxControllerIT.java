package com.cpal.it;

import com.cpal.vo.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaxControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/tax");
    }

    @Test
    public void getTax_returnsValidResponse() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        assertThat(response.getBody(), equalTo("Return Tax results for all the states!"));
    }

    @Test
    public void getStates_returnsValidResponse() throws Exception {
      ResponseEntity<ArrayList> response = template.getForEntity(base.toString(),ArrayList.class);
        Type[] types = ()response.getBody();
        assertThat(types.length, is(50));
    }
}



