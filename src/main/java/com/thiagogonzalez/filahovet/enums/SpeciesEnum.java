package com.thiagogonzalez.filahovet.enums;

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
