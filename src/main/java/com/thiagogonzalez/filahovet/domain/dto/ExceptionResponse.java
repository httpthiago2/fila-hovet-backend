package com.thiagogonzalez.filahovet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;
}
