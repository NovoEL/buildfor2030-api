package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "SDG not found")
public class SDGNotFoundException extends RuntimeException {

    public SDGNotFoundException() {
    }

    public SDGNotFoundException(String message) {
        super(message);
    }
}