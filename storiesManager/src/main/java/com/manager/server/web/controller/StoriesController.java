package com.manager.server.web.controller;

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.server.api.StoryTasks;
import com.manager.server.api.bean.Task;

@Controller
public class StoriesController implements MessageSourceAware {

    private static final Logger log = LogManager.getLogger(StoriesController.class);
    private MessageSource messageSource;

    @RequestMapping(value = "/stories", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Task> stories(Locale locale) {

        log.debug("Got request to @@@ stories {}");
        StoryTasks stories = new StoryTasks();
        return stories.getTasks() ;
    }


    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
        log.debug("Got request to @@@ stories {}", this.messageSource);
    }
}