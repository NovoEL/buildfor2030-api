package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Solution idea not found")
public class SolutionIdeaNotFoundException extends RuntimeException {

    public SolutionIdeaNotFoundException() {
    }

    public SolutionIdeaNotFoundException(String message) {
        super(message);
    }
}

