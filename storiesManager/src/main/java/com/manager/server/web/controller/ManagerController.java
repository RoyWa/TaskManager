package com.manager.server.web.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.server.api.Errors;
import com.manager.server.api.Infos;
import com.manager.server.api.request.IdQuery;
import com.manager.server.api.response.Response;
import com.manager.server.api.response.ResponseBuilder;
import com.manager.server.api.response.ResponseStatus;

@Controller
public class ManagerController implements MessageSourceAware {

    private static final Logger log = LogManager.getLogger(ManagerController.class);
    private MessageSource messageSource;

    @RequestMapping(value = "/view", method = { RequestMethod.POST },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<Response> view(@Valid @RequestBody IdQuery query, BindingResult bindingResult, Locale locale) {

        log.debug("Got request to view {}", query);
        Response response = new Response();

        boolean isValid = validate(bindingResult);
        if (! isValid) {
            ResponseBuilder.updateResponse(messageSource, Errors.ERR_01, ResponseStatus.Failure, response, locale);
            log.debug("Returning - {}", response);
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            // Do something here, for now dummy setting status
            response.setStatus(ResponseStatus.Success);
        } catch (Exception e) {
            String error = "Failed to view, " + query;
            log.error(error, e);

            ResponseBuilder.updateResponse(messageSource, Errors.ERR_05, ResponseStatus.Failure, response, locale);

            log.debug("Returning - {}", response);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ResponseBuilder.updateResponse(messageSource, Infos.MSG_01, ResponseStatus.Success, response, locale);

        log.debug("Returning - {}", response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    private boolean validate(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach((error) -> {
                log.error("Validation {} {}", error.getCodes()[0], error.getDefaultMessage());
            });

            return false;
        }

        return true;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}