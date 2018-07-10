package com.cpal.work.force.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService subject;

    @Test
    public void getMessage_returnMessage() {
        assertThat(subject.getMessage(), is("Welcome to Work Force Management"));
    }


}
