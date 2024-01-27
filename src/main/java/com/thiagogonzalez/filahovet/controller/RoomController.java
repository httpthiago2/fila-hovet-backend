package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.ResponseObject;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;
import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.mapper.RoomMapper;
import com.thiagogonzalez.filahovet.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<ResponseObject> findAll() {

        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Salas encontradas com sucesso",
                LocalDateTime.now(), RoomMapper.INSTANCE.roomsToRoomDTOs(service.getAllRooms())),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseObject> createRoom(@RequestBody RoomDTO dto) {
        Room roomCreated = service.createRoom(RoomMapper.INSTANCE.roomDTOtoRoom(dto));
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Sala criada com sucesso",
                LocalDateTime.now(), RoomMapper.INSTANCE.roomToRoomDTO(roomCreated)
        ),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateRoom(@PathVariable("id") Long id, @RequestBody RoomDTO dto) {
        Room roomEntityUpdated = service.updateRoom(id, RoomMapper.INSTANCE.roomDTOtoRoom(dto));
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Sala atualizada com sucesso",
                LocalDateTime.now(), RoomMapper.INSTANCE.roomToRoomDTO(roomEntityUpdated)
        ),
                HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> deleteRoom(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Sala Deletada com sucesso",
                LocalDateTime.now(), RoomMapper.INSTANCE.roomToRoomDTO(service.deleteRoom(id))
        ),
                HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Sala Encontrada com sucesso",
                LocalDateTime.now(),
                RoomMapper.INSTANCE.roomToRoomDTO(service.getRoomById(id))
        ),
                HttpStatus.OK);
    }
}
