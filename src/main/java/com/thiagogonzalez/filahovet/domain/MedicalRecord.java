package com.thiagogonzalez.filahovet.domain;

import com.thiagogonzalez.filahovet.domain.enums.GenderEnum;
import com.thiagogonzalez.filahovet.domain.enums.SpeciesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEDICAL_RECORD")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String petName;

    private String tutor;

    private BigDecimal weight;

    private LocalDateTime registerDate;

    private String complaint;

    @Enumerated(EnumType.STRING)
    private SpeciesEnum species;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne
    @JoinColumn(name = "queue_id")
    private Queue queue;
}
