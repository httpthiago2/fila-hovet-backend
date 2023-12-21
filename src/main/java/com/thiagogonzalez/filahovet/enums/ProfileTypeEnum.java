package com.thiagogonzalez.filahovet.enums;

import lombok.Getter;

@Getter
public enum ProfileTypeEnum {
    DOCTOR("Médico"),
    SECRETARY("Secretário"),
    DIRECTOR("Diretor");

    private final String description;

    ProfileTypeEnum(String description) {
        this.description = description;
    }
}
