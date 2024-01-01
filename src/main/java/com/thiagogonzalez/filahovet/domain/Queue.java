package com.thiagogonzalez.filahovet.domain;

import com.thiagogonzalez.filahovet.domain.enums.QueueStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "queue")
@Getter @Setter @NoArgsConstructor
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private QueueStatusEnum queueStatusEnum;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "queue")
    private List<MedicalRecord> medicalRecords;

    private String userCode;
}