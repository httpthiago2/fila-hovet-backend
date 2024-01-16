package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper( RoomMapper.class );

    RoomDTO roomToRoomDTO(Room room);
    Room roomDTOtoRoom(RoomDTO roomDTO);
    Room createRoomDTOtoRoom(CreateRoomDTO createRoomDTO);
    List<RoomDTO> roomsToRoomDTOs(List<Room> rooms);
}