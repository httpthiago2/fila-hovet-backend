package com.thiagogonzalez.filahovet.domain.entities;

import com.thiagogonzalez.filahovet.domain.enums.ProfileTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_USER")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private ProfileTypeEnum profileTypeEnum;
}