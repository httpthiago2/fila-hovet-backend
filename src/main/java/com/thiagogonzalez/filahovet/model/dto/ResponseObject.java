package com.thiagogonzalez.filahovet.model.dto;

import java.time.LocalDateTime;

public record ResponseObject(String code, String message, LocalDateTime time, Object data) {
}
