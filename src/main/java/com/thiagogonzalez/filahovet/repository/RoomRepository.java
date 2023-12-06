package com.thiagogonzalez.filahovet.repository;

import com.thiagogonzalez.filahovet.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
