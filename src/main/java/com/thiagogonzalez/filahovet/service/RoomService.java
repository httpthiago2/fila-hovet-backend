package com.thiagogonzalez.filahovet.service;

import com.thiagogonzalez.filahovet.model.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.model.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    public List<RoomDTO> getAllRooms();
    public RoomDTO createRoom(CreateRoomDTO dto);
    public RoomDTO updateRoom(RoomDTO dto) throws Exception;
    public RoomDTO deleteRoom(Long id) throws Exception;
}
