package com.cpal.work.force.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkForceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getMessage_returnValidResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/workforce/message").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    

}
