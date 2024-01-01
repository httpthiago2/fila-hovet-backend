package com.thiagogonzalez.filahovet.domain.enums;

import lombok.Getter;

@Getter
public enum QueueStatusEnum {
    OPEN("Aberto"),
    CLOSED("Fechado");

    private final String description;

    QueueStatusEnum(String description) {
        this.description = description;
    }
}
