package com.thiagogonzalez.filahovet.service;

import com.thiagogonzalez.filahovet.mapper.RoomMapper;
import com.thiagogonzalez.filahovet.model.Room;
import com.thiagogonzalez.filahovet.model.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.model.dto.RoomDTO;
import com.thiagogonzalez.filahovet.repository.RoomRepository;
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

    public RoomDTO updateRoom(RoomDTO dto) throws Exception {
        if (!repository.existsById(dto.id())) {
            throw new Exception("There are no rooms for id: " + dto.id());
        }
        return RoomMapper.INSTANCE.roomToRoomDTO(
                repository.save(RoomMapper.INSTANCE.roomDTOtoRoom(dto))
        );
    }

    public RoomDTO deleteRoom(Long id) throws Exception {
        logger.info("###Deleting room");
        Room roomToDelete = repository.findById(id).orElseThrow();
        repository.deleteById(id);
        return RoomMapper.INSTANCE.roomToRoomDTO(roomToDelete);
    }
}
