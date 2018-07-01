package com.cpal.work.force;

import com.cpal.work.force.client.WorkForceClient;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WorkForceIT {

    private WorkForceClient workForceClient = new WorkForceClient("localhost", "8899");

    @Test

    public void getMessage_returnsValidResponse() {
        String actual = workForceClient.getMessage();
        assertThat(actual, is("Welcome to Work Force Management"));
    }

}
