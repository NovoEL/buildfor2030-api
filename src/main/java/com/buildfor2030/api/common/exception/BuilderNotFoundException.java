package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Builder not found")
public class BuilderNotFoundException extends RuntimeException {

    public BuilderNotFoundException() {
    }

    public BuilderNotFoundException(String message) {
        super(message);
    }
}
