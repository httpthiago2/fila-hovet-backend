package com.thiagogonzalez.filahovet.services;

import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.mapper.RoomMapper;
import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;
import com.thiagogonzalez.filahovet.repositories.RoomRepository;
import org.springframework.beans.BeanUtils;
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


    public List<Room> getAllRooms() {
        logger.info("###Listing a room");
        return repository.findAll();
    }

    public Room createRoom(Room room) {
        logger.info("###Creating a room");
        return repository.save(room);
    }

    public Room updateRoom(Long id, Room newRoomData) {
        Room existingRoom = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));

        BeanUtils.copyProperties(newRoomData, existingRoom);
        existingRoom.setId(id);

        return repository.save(existingRoom);
    }

    public Room deleteRoom(Long id) {
        logger.info("###Deleting room");
        Room roomToDelete = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        repository.deleteById(id);
        return roomToDelete;
    }

    public Room getRoomById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
    }


}
