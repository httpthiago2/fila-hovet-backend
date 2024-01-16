package com.thiagogonzalez.filahovet.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessRuleNotAttendedException extends RuntimeException{
    public BusinessRuleNotAttendedException(String ex) {
        super(ex);
    }
}
