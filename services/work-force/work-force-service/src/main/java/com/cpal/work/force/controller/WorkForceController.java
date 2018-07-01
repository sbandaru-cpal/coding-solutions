package com.cpal.work.force.controller;

import com.cpal.work.force.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/workforce", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class WorkForceController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    public @ResponseBody String getMessage() {
        return messageService.getMessage();
    }
}




