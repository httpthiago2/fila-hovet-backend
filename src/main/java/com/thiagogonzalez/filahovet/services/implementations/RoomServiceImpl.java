package com.thiagogonzalez.filahovet.services.implementations;

import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.mapper.RoomMapper;
import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;
import com.thiagogonzalez.filahovet.repositories.RoomRepository;
import com.thiagogonzalez.filahovet.services.interfaces.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RoomServiceImpl implements RoomService {
    private final Logger logger = Logger.getLogger(RoomServiceImpl.class.getName());
    private final RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        logger.info("###Listing a room");
        List<Room> rooms = repository.findAll();
        return RoomMapper.INSTANCE.roomsToRoomDTOs(rooms);
    }

    @Override
    public RoomDTO createRoom(CreateRoomDTO dto) {
        logger.info("###Creating a room");
        Room room = repository.save(RoomMapper.INSTANCE.createRoomDTOtoRoom(dto));
        return RoomMapper.INSTANCE.roomToRoomDTO(room);
    }

    @Override
    public RoomDTO updateRoom(RoomDTO dto) {
        if (!repository.existsById(dto.id())) {
            throw new ResourceNotFoundException("There are no rooms for id: " + dto.id());
        }
        return RoomMapper.INSTANCE.roomToRoomDTO(
                repository.save(RoomMapper.INSTANCE.roomDTOtoRoom(dto))
        );
    }

    @Override
    public RoomDTO deleteRoom(Long id) {
        logger.info("###Deleting room");
        Room roomToDelete = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        repository.deleteById(id);
        return RoomMapper.INSTANCE.roomToRoomDTO(roomToDelete);
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        Room roomEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        return RoomMapper.INSTANCE.roomToRoomDTO(roomEntity);
    }


}
