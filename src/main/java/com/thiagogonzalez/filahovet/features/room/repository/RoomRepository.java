package com.thiagogonzalez.filahovet.features.room.repository;

import com.thiagogonzalez.filahovet.features.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
