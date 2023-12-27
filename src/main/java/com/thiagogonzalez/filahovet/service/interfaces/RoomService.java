package com.thiagogonzalez.filahovet.service.interfaces;

import com.thiagogonzalez.filahovet.model.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.model.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO createRoom(CreateRoomDTO dto);
    RoomDTO updateRoom(RoomDTO dto);
    RoomDTO deleteRoom(Long id);
    RoomDTO getRoomById(Long id);
}
