package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.dto.MedicalRecordDTO;
import com.thiagogonzalez.filahovet.domain.dto.QueueDTO;
import com.thiagogonzalez.filahovet.domain.dto.ResponseObject;
import com.thiagogonzalez.filahovet.mapper.MedicalRecordMapper;
import com.thiagogonzalez.filahovet.services.implementations.QueueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/queue")
public class QueueController extends GenericController<Queue, QueueDTO> {


    private final QueueService service;

    public QueueController(QueueService service) {
        super(service, QueueDTO.class, Queue.class);
        this.service = service;
    }

    @PostMapping(
            value = "/adicionar-registro-medico/{queueId}"
    )
    public ResponseEntity<ResponseObject> addMedicalRecord(@PathVariable("queueId") Long queueId,
                                                           @RequestBody MedicalRecordDTO record) {
        MedicalRecord entity = MedicalRecordMapper.INSTANCE.toModel(record);
        return new ResponseEntity<>(
                new ResponseObject(
                        "success",
                        "Prontuário adicionado com sucesso",
                        LocalDateTime.now(),
                        service.addMedicalRecord(queueId, entity)
                ),
                HttpStatus.OK
        );
    }
}
