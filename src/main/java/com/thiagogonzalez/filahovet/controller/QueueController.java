package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.dto.QueueDTO;
import com.thiagogonzalez.filahovet.domain.dto.ResponseObject;
import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.mapper.QueueMapper;
import com.thiagogonzalez.filahovet.mapper.RoomMapper;
import com.thiagogonzalez.filahovet.services.QueueService;
import com.thiagogonzalez.filahovet.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/queue")
public class QueueController {


    private final QueueService service;
    private final RoomService roomService;

    public QueueController(QueueService service, RoomService roomService) {
        this.service = service;
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<ResponseObject> findAll() {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                QueueMapper.INSTANCE.fromModelList(service.findAll())),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                QueueMapper.INSTANCE.fromModel(service.findById(id))),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody QueueDTO queueDTO) {
        Queue queue = QueueMapper.INSTANCE.toModel(queueDTO);
        queue.setRoom(RoomMapper.INSTANCE.roomDTOtoRoom(roomService.getRoomById(queueDTO.getRoom().id())));
        Queue queueCreated = service.create(queue);
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Fila criada com sucesso!",
                LocalDateTime.now(),
                QueueMapper.INSTANCE.fromModel(queueCreated)),
                HttpStatus.CREATED
        );
    }

    @PutMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> update(@PathVariable("id") Long id, @RequestBody QueueDTO queueDTO) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Fila atualizada com sucesso",
                LocalDateTime.now(),
                service.update(id, QueueMapper.INSTANCE.toModel(queueDTO))),
                HttpStatus.OK
        );
    }
}
