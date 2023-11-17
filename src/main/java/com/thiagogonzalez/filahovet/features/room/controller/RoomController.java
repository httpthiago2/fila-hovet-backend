package com.thiagogonzalez.filahovet.features.room.controller;

import com.thiagogonzalez.filahovet.features.room.service.RoomService;
import com.thiagogonzalez.filahovet.features.room.dto.RoomDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<Page<RoomDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRoom(roomDTO));
    }

    @PutMapping()
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO) {
        try {
            return ResponseEntity.ok(service.updateRoom(roomDTO));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<RoomDTO> deleteRoom(@PathVariable Long id) {
        try {
            service.deleteRoom(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
