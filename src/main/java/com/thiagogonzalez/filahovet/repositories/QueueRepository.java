package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
}
