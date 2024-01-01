package com.thiagogonzalez.filahovet.services.interfaces;

import com.thiagogonzalez.filahovet.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO dto);
    UserDTO updateUser(UserDTO id);
    UserDTO deleteUser(Long id);
    UserDTO findUserById(Long id);
    List<UserDTO> getAllUsers();
}
