package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Stack not found")
public class StackNotFoundException extends RuntimeException {

    public StackNotFoundException() {
    }

    public StackNotFoundException(String message) {
        super(message);
    }
}
