package com.cpal.controller;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaxControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getTax_returnValidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tax").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Return Tax results for all the states!")));
    }

    @Test
    public void getStates_returnValidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tax").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               /* .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
                .andExpect(jsonPath("$[0].title", is("Foo")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
                .andExpect(jsonPath("$[1].title", is("Bar")));
                .andExpect(content().string(equalTo("Return Tax results for all the states!")));*/


       /* MvcResult actual = mvc.perform(MockMvcRequestBuilders.get("/tax/states").accept(MediaType.APPLICATION_JSON)).andReturn();
        int status  =  actual.getResponse().getStatus();
        actual.getResponse().

        Assert.assertThat(status, Is.is(200));*/

              //  .andExpect(status().isOk());
               // .andExpect(content().(equalTo("Return Tax results for all the states!")));
    }
}
