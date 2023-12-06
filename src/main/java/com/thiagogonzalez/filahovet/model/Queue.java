package com.thiagogonzalez.filahovet.model;

import com.thiagogonzalez.filahovet.enums.QueueStatusEnum;
import com.thiagogonzalez.filahovet.model.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private LocalDate creationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private QueueStatusEnum statusFilaEnum;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
