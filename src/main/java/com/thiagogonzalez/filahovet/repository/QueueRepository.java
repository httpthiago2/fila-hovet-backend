package com.thiagogonzalez.filahovet.repository;

import com.thiagogonzalez.filahovet.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
}
