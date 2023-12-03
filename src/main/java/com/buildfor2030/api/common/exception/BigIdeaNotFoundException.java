package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "BigIdea not found")
public class BigIdeaNotFoundException extends RuntimeException {

    public BigIdeaNotFoundException() {
    }

    public BigIdeaNotFoundException(String message) {
        super(message);
    }
}
