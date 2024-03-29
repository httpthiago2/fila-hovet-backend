package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
