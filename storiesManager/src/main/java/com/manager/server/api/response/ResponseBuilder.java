package com.manager.server.api.response;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class ResponseBuilder {

    public static <T extends Response> void updateResponse(MessageSource messageSource, String code,
                                                           ResponseStatus status, T response,
                                                           Locale locale, Object... args) {

        response.setStatus(status);
        response.setCode(code);

        String message = messageSource.getMessage(code, args, locale);
        response.setMessage(message);
    }
}
