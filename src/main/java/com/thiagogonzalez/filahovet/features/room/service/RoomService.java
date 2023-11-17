package com.thiagogonzalez.filahovet.features.room.service;

import com.thiagogonzalez.filahovet.features.room.dto.RoomDTO;
import com.thiagogonzalez.filahovet.features.room.model.Room;
import com.thiagogonzalez.filahovet.features.room.repository.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Page<RoomDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(room -> new RoomDTO(room.getId(), room.getName()));
    }

    public RoomDTO createRoom(RoomDTO dto) {
        Room roomEntity = new Room();
        BeanUtils.copyProperties(dto, roomEntity);
        repository.save(roomEntity);
        return dto;
    }

    public RoomDTO updateRoom(RoomDTO dto) throws Exception {
        if (!repository.existsById(dto.id())) {
            throw new Exception("Não existe registro para esse id");
        }
        Room roomEntity = new Room();
        BeanUtils.copyProperties(dto, roomEntity);
        repository.save(roomEntity);
        return dto;
    }

    public void deleteRoom(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("Não existe registro para esse id");
        }

       repository.deleteById(id);
    }
}
