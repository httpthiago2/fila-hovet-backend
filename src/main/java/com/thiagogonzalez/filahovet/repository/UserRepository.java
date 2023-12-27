package com.thiagogonzalez.filahovet.repository;

import com.thiagogonzalez.filahovet.model.User;
import com.thiagogonzalez.filahovet.model.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
