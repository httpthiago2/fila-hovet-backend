package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.model.dto.CreateRoomDTO;
import com.thiagogonzalez.filahovet.model.dto.RoomDTO;
import com.thiagogonzalez.filahovet.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping()
    public List<RoomDTO> findAll() {
        return service.getAllRooms();
    }

    @PostMapping
    public RoomDTO createRoom(@RequestBody CreateRoomDTO dto) {
        return service.createRoom(dto);
    }

    @PutMapping
    public RoomDTO updateRoom(@RequestBody RoomDTO dto){
        return service.updateRoom(dto);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public RoomDTO deleteRoom(@PathVariable("id") Long id){
        return service.deleteRoom(id);
    }

    @GetMapping(
            value = "/{id}"
    )
    public RoomDTO findById(@PathVariable Long id){
        return service.getRoomById(id);
    }
}
