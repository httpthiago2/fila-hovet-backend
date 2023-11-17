package com.thiagogonzalez.filahovet.features.room.model;

import com.thiagogonzalez.filahovet.features.queue.model.Queue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room")
@Getter @Setter @NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "room")
    private List<Queue> queues;
}
