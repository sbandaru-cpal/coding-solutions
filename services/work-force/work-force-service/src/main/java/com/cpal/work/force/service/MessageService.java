package com.cpal.work.force.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public static final String MESSAGE = "Welcome to Work Force Management";

    public String getMessage() {
        return MESSAGE;
    }
}
