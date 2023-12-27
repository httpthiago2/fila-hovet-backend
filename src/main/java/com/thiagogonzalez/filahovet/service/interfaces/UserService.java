package com.thiagogonzalez.filahovet.service.interfaces;

import com.thiagogonzalez.filahovet.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO dto);
    UserDTO updateUser(UserDTO id);
    UserDTO deleteUser(Long id);
    UserDTO findUserById(Long id);
    List<UserDTO> getAllUsers();
}
