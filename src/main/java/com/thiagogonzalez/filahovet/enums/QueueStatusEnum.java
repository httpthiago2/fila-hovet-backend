package com.thiagogonzalez.filahovet.enums;

import lombok.Getter;

@Getter
public enum QueueStatusEnum {
    ABERTO("Aberto"),
    FECHADO("Fechado");

    private final String description;

    QueueStatusEnum(String description) {
        this.description = description;
    }

}
