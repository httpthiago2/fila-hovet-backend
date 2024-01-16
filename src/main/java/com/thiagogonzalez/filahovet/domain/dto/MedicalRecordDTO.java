package com.thiagogonzalez.filahovet.domain.dto;

import com.thiagogonzalez.filahovet.domain.enums.GenderEnum;
import com.thiagogonzalez.filahovet.domain.enums.SpeciesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class MedicalRecordDTO {
    Long id;
    String petName;
    String tutor;
    BigDecimal weight;
    LocalDateTime registerDate;
    String complaint;
    SpeciesEnum species;
    GenderEnum gender;
}
