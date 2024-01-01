package com.thiagogonzalez.filahovet.domain.dto;

import com.thiagogonzalez.filahovet.domain.enums.ProfileTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class UserDTO {
    Long id;
    String name;
    String userName;
    String password;
    ProfileTypeEnum profileTypeEnum;
}
