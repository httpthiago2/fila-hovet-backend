package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {

}
