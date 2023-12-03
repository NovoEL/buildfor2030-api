package com.buildfor2030.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Partner API not found")
public class PartnerAPINotFoundException extends RuntimeException {

    public PartnerAPINotFoundException() {
    }

    public PartnerAPINotFoundException(String message) {
        super(message);
    }
}