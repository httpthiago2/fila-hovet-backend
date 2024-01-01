package com.thiagogonzalez.filahovet.services.interfaces;

import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO createRoom(CreateRoomDTO dto);
    RoomDTO updateRoom(RoomDTO dto);
    RoomDTO deleteRoom(Long id);
    RoomDTO getRoomById(Long id);
}
