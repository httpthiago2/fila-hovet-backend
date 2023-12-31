package com.thiagogonzalez.filahovet.domain.enums;

import lombok.Getter;

@Getter
public enum GenderEnum {
    MALE("Feminino"),
    FEMALE("Masculino");

    private final String description;

    GenderEnum(String description) {
        this.description = description;
    }

}
