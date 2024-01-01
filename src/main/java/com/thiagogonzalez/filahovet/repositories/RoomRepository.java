package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
