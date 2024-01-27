package com.thiagogonzalez.filahovet.services;

import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.mapper.RoomMapper;
import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;
import com.thiagogonzalez.filahovet.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RoomService {
    private final Logger logger = Logger.getLogger(RoomService.class.getName());
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }


    public List<RoomDTO> getAllRooms() {
        logger.info("###Listing a room");
        List<Room> rooms = repository.findAll();
        return RoomMapper.INSTANCE.roomsToRoomDTOs(rooms);
    }

    public RoomDTO createRoom(CreateRoomDTO dto) {
        logger.info("###Creating a room");
        Room room = repository.save(RoomMapper.INSTANCE.createRoomDTOtoRoom(dto));
        return RoomMapper.INSTANCE.roomToRoomDTO(room);
    }

    public RoomDTO updateRoom(RoomDTO dto) {
        if (!repository.existsById(dto.id())) {
            throw new ResourceNotFoundException("There are no rooms for id: " + dto.id());
        }
        return RoomMapper.INSTANCE.roomToRoomDTO(
                repository.save(RoomMapper.INSTANCE.roomDTOtoRoom(dto))
        );
    }

    public RoomDTO deleteRoom(Long id) {
        logger.info("###Deleting room");
        Room roomToDelete = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        repository.deleteById(id);
        return RoomMapper.INSTANCE.roomToRoomDTO(roomToDelete);
    }

    public RoomDTO getRoomById(Long id) {
        Room roomEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        return RoomMapper.INSTANCE.roomToRoomDTO(roomEntity);
    }


}
