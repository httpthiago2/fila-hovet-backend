package com.thiagogonzalez.filahovet.model;

import com.thiagogonzalez.filahovet.enums.ProfileTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userName;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private ProfileTypeEnum profileTypeEnum;
}