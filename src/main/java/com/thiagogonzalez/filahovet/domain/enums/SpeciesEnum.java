package com.thiagogonzalez.filahovet.domain.enums;

import lombok.Getter;

@Getter
public enum SpeciesEnum {
    FELINE("Felino"),
    CANINE("Canino");

    private final String description;

    SpeciesEnum(String description) {
        this.description = description;
    }

}
