package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Answer not found")
public class AnswerNotFoundException extends RuntimeException {

    public AnswerNotFoundException() {
    }

    public AnswerNotFoundException(String message) {
        super(message);
    }
}
