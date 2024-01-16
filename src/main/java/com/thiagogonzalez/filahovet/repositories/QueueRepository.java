package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.entities.Queue;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface QueueRepository extends GenericRepository<Queue> {
}
