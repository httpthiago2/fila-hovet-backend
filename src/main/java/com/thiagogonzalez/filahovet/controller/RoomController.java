package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.domain.dto.ResponseObject;
import com.thiagogonzalez.filahovet.domain.dto.RoomDTO;
import com.thiagogonzalez.filahovet.services.interfaces.RoomService;
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
                LocalDateTime.now(), service.getAllRooms()),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseObject> createRoom(@RequestBody CreateRoomDTO dto) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Sala criada com sucesso",
                LocalDateTime.now(), service.createRoom(dto)
        ),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseObject> updateRoom(@RequestBody RoomDTO dto) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Sala atualizada com sucesso",
                LocalDateTime.now(), service.updateRoom(dto)
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
                LocalDateTime.now(), service.deleteRoom(id)
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
                LocalDateTime.now(), service.getRoomById(id)
        ),
                HttpStatus.OK);
    }
}
