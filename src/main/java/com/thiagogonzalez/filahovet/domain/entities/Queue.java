package com.thiagogonzalez.filahovet.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thiagogonzalez.filahovet.domain.enums.QueueStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_QUEUE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private QueueStatusEnum queueStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @JsonManagedReference
    @OneToMany(mappedBy = "queue")
    private List<MedicalRecord> medicalRecords;

    private String userCode;

}
